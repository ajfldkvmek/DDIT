package kr.or.ddit.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

public class JsopTest {
	static int cpu = Runtime.getRuntime().availableProcessors();

	static ThreadPoolExecutor executorService = ThreadPool.WaitAndRun("crawler",  cpu, cpu*2);
	public static void main(String[] args) {
		System.out.println(cpu);

		
		Date date = new Date();
		for(int i=0; i<100; i++){
			String url = "https://www.yes24.com/24/Category/Display/001001046011";
//			System.out.println(JsopTest.getHtml(url));
			executorService.execute(new ThreadJob(url));
		}
		Date date1 = new Date();
		System.out.println(date1.getTime()-date.getTime());



/*		String html = doc.html();
		System.out.println(html);
		String path = "D:/data/list/";
		File list = new File(path);
		if (!list.exists()) {
			list.mkdirs();
		}
		String name = url.replace("https://www.yes24.com/", "").replace("/", "@");
		System.out.println(name);
		File file = new File(path + name + ".html");
		try {
			Files.write(file.toPath(), html.getBytes());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
*/
	}


	public static String getHtml(String url){
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String html = doc.html();
		return html;
	}
}
