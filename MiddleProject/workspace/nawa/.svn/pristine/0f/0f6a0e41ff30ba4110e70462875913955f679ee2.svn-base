package member.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/captcha.do")
public class Captcha extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reCAPTCHA 검증을 위한 서버 사이드 로직
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean isValid = YourRecaptchaVerificationMethod(gRecaptchaResponse);

        if (isValid) {
            // reCAPTCHA가 유효하면 폼 처리 로직을 여기에 추가
            // 예: 데이터베이스에 저장, 이메일 전송 등
            response.getWriter().println("reCAPTCHA validation passed!");
        } else {
            // reCAPTCHA가 유효하지 않으면 사용자에게 오류 메시지를 표시하거나 다른 처리를 수행
            response.getWriter().println("reCAPTCHA validation failed!");
        }
    }

    private boolean YourRecaptchaVerificationMethod(String gRecaptchaResponse) {
        // Google reCAPTCHA v3 API를 호출하여 토큰을 확인하는 로직
        String secretKey = "6LcjWFIpAAAAABfaR1GlyMUT5ew3-rdnTo-qX8j_";
        String url = "https://www.google.com/recaptcha/api/siteverify";
        String params = "secret=" + secretKey + "&response=" + gRecaptchaResponse;

        try {
            // API 호출
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            // API 파라미터 전송
            OutputStream os = con.getOutputStream();
            os.write(params.getBytes());
            os.flush();
            os.close();
            
            
            
            // API 응답 읽기
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder responseContent = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();

           
            return responseContent.toString().contains("\"success\": true");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
