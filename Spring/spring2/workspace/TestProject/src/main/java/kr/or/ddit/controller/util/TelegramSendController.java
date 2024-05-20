package kr.or.ddit.controller.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TelegramSendController {

	// 텔레그램 봇이 초대되어 있는 방으로 메시지가 전송된다.
	public void sendGet(String name, String title) throws Exception {
		String chatId = "-4164545082";
		String urlName = "https://api.telegram.org/bot6310783618:AAEI3ptPtCArMaRYoKBHxfHhjOuYcDbVUaY/sendMessage";
		String text = ""; // 전송할 메세지
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time_ = format.format(time);
		
		text = name + "님께서 글 작성을 완료하였습니다! \n" +
				"[제목] " + title + "\n" +
				"[작성일] " + time_ + "\n";
		
		URL url = new URL(urlName + "?chat_id=" + chatId + "&text=" +
				URLEncoder.encode(text, "UTF-8"));
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST"); // 대문자 POST
		conn.setRequestProperty("User-Agent", "Mozilla/5.0");
		int respCode = conn.getResponseCode();
		System.out.println("####### 텔레그램 봇 API 통신 결과? " + respCode);
		
	}
}
