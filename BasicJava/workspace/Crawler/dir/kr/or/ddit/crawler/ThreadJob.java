package kr.or.ddit.crawler;

import java.io.File;
import java.util.Date;

public class ThreadJob extends Thread{
    static int cnt =0;
    String url;
    public ThreadJob(String url){
        this.url = url;
    }

    static Date date = new Date();
    @Override
    public void run() {
//        System.out.println(JsopTest.getHtml("Q"));
//        System.out.println(url + " : " + ++cnt);
//
//        File f = new File("url");
//        if(f.exists()) return;
//        try {
//        	
//        	//여기서푸터 파일 저장 한다는 말인듯 ?
//        } catch (InterruptedException e) {
//            JsopTest.getHtml(url);
//            e.printStackTrace();
//        }
//        if(cnt == 100){
//            Date date2 = new Date();
//            System.out.println(date2.getTime() - date.getTime());
//        }
               
    }

    public void write(){

    }

    public void getHtml(){

    }
}
