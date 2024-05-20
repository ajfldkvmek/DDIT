package atch.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atch.service.BoardAtchFileServiceImpl;
import atch.service.IBoardAtchFileService;
import atch.vo.BoardAtchFileVO;

@WebServlet("/fileDownload.do")
public class BoardDownloadController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		key값 다 써주기
		long boardFIndex = req.getParameter("fileId") == null ? 0 : Long.parseLong(req.getParameter("fileId")); // null체크
//		int fileSn = req.getParameter("fileSn") == null ? 0 : Integer.parseInt(req.getParameter("fileSn"));
		// http://localhost:8888/ServletExam/fileDownload.do?fileId=18&fileSn=1

		IBoardAtchFileService fileService = BoardAtchFileServiceImpl.getInstance();

		BoardAtchFileVO boardAtchFileVO = new BoardAtchFileVO();
		boardAtchFileVO.setBoardFIndex(boardFIndex);
//		atchFileVO.setFileSn(fileSn);

		boardAtchFileVO = fileService.getBoardAtchFileDetail(boardAtchFileVO);

		/*
		 * Content-Disposition 헤더에 대하여...
		 * 
		 * Response 헤더에 사용되는 경우 ex) 파일 다운로드
		 * 
		 * Content-Disposition: inline (default) Content-Disposition: attachment (사용자가
		 * 바로 다운받을 수 있게 해줌)(filename이 없어서 서블릿 이름으로 다운받게 됨) Content-Disposition:
		 * attachment; filename="filename.jpg"
		 */

		// (바이너리 데이터라는 뜻)(text/html 같은 타입 지정)
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=\""
				+ URLEncoder.encode(boardAtchFileVO.getBoardOriName(), "UTF-8").replaceAll("\\+", "%20") + "\"");
//		resp.setContentType("image/jpg");

		// URL에는 공백문자를 포함할 수 없다. URLEncoding을 이용하여 인코딩 작업을 하면
		// 공백은 +로 표시되기 때문에 +문자를 공백문자인 %20으로 일괄적으로 바꿔준다.

		/*
		 * BufferedInputStream bis = new BufferedInputStream(new
		 * FileInputStream(boardAtchFileVO.getFileStreCours())); BufferedOutputStream
		 * bos = new BufferedOutputStream(resp.getOutputStream());
		 * 
		 * int data = 0; while ((data = bis.read()) != -1) { bos.write(data); }
		 * 
		 * bis.close(); bos.close();
		 */

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
