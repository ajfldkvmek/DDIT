package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.StringTokenizer;

public class MyHttpServer {

	private final int port = 80;
	private final String encoding = "UTF-8";

	public void start() {
		System.out.println("HTTP 서버 시작");

		ServerSocket server = null;

		try {
			server = new ServerSocket(this.port);

			while (true) {

				Socket socket = server.accept();
				HttpHandler handler = new HttpHandler(socket);
				handler.start();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * HTTP요청 처리를 위한 쓰레드 클래스
	 */

	class HttpHandler extends Thread {

		private final Socket socket;

		public HttpHandler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			BufferedOutputStream bos = null;
			BufferedReader br = null;

			try {
				bos = new BufferedOutputStream(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// 요청 헤더정보 파싱하기
				String reqLine = br.readLine();
//				System.out.println("request Line: " +  reqLine);

				StringBuilder sb = new StringBuilder();
				while (true) {

					String str = br.readLine();

					if (str.equals("")) {
//						br.close();
						break;
					}
					sb.append(str + "\n");
				}

				// StringTokenizer로 요청경로 가져오기
				String reqPath = "";
				StringTokenizer st = new StringTokenizer(reqLine);

				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if (token.startsWith("/")) {
						reqPath = token;
						break;
					}
				}

				System.out.println("요청경로=> " + reqPath);

				reqPath = URLDecoder.decode(reqPath, "UTF-8");

				String filePath = "./web-contents" + reqPath;

				// 해당파일 이름을 이용하여 content-type정보 추출하기
				String contentType = URLConnection.getFileNameMap().getContentTypeFor(filePath);

				// css파일인 경우 인식이 안되서 추가
				if (contentType == null && filePath.equals(".css")) {
					contentType = "tex/css";
				}

				System.out.println("contentType=> " + contentType);
				File file = new File(filePath);

				if (!file.exists()) {
					makeErrorPage(bos, 404, "Not fount");
					return;
				}

				byte[] body = makeResponseBody(filePath);
				byte[] header = makeResponseHeader(body.length, contentType);

				bos.write(header); // 헤더정보 전송하기

				bos.write("\r\n\r\n".getBytes());// emptyline 무적권 전송(헤더 바디 구분)

				bos.write(body); // 응답내용(body) 전송하기
				bos.flush(); // 강제버퍼비우기

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		/**
		 * 에러 페이지 생성
		 * @param bos
		 * @param statusCode
		 * @param errMsg
		 */
		private void makeErrorPage(BufferedOutputStream bos, 
										int statusCode, String errMsg) {
			String statusLine = "HTTP/1.1" + " " + statusCode + " " + errMsg;
			
			try {
				bos.write(statusLine.getBytes());
				bos.flush();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
			
		}

		private byte[] makeResponseHeader(int length, String contentType) {
			
			String headerStr = "HTTP/1.1 200 OK\r\n"
					+ "Server: MyHttpServer 1.0\r\n"
					+ "Content-Length:" + contentType +"\r\n"
					+ "Content-Type: " + contentType + "\r\n" + "; charset=UTF=8";
			
			return headerStr.getBytes();
		}

		/**
		 * 응답내용 생성하기
		 * 
		 * @param filePath 응답으로 사용할 파일경로
		 * @param contentType 응답내용 마임 탑입
		 * @return 파일내용을 담은 바이트 배열 테이터
		 */
		private byte[] makeResponseBody(String filePath) {

			FileInputStream fis = null;
			byte[] data = null;
			
			try {
				File file = new File(filePath);
				data = new byte[(int)file.length()];
				
				fis = new FileInputStream(file);
				fis.read(data);
				
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return null;
		}
	}

	public static void main(String[] args) {
		new MyHttpServer().start();
	}
}
