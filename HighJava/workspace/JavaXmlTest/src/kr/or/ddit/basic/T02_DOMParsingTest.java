package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class T02_DOMParsingTest {

	public void parseDoc() throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();

		Document document = builder.parse(new File("./src/new_book.xml"));
		
		//Document객체로부터 루트엘리먼트를 가져오기
		Element rootEl = document.getDocumentElement();
		System.out.println("루트 엘리먼트 태그명: " + rootEl.getTagName());
		
		//하위엘리멘트접근하기
		NodeList bookNodelist = rootEl.getElementsByTagName("book");
		Node firstBookNode = bookNodelist.item(0); //첫번째 항목
		Element firstBookEl = (Element) firstBookNode;
		
		//속성값 접근하기 속성값은 getAttribute를 사용
		System.out.println("엘리먼트 객체의 getAttribute()이용=> "
							+firstBookEl.getAttribute("isbn"));
		
		// 엘리먼트의 textContent 접근하기 내용은 getTextContent를 사용
		String title2 = 
				firstBookEl.getElementsByTagName("title").item(0).getTextContent();
		System.out.println("첫번째 책의 타이틀: " + title2);
		//////////////////////////////////////////////////////////////////////////////
		
		//전체정보 출력
		System.out.println("---------------------------------------------------------");

		System.out.printf("%8s %8s %12s %10s %8s\n",  "isbn", "분류", "제목", "저자", "가격");
		System.out.println("---------------------------------------------------------");
		
		for(int i=0; i < bookNodelist.getLength(); i++) {
			Element bookEl = (Element) bookNodelist.item(i);
		
			String isbn = bookEl.getAttribute("isbn");
			String kind = bookEl.getAttribute("kind");
			
			String title = bookEl.getElementsByTagName("title").item(0).getTextContent().trim();
			String author = bookEl.getElementsByTagName("author").item(0).getTextContent().trim();
			String price = bookEl.getElementsByTagName("price").item(0).getTextContent().trim();
		
			System.out.printf("%8s %8s %12s %10s %8s\n", isbn, kind, title, author, price);
		}
		
		System.out.println("---------------------------------------------------------");
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		new T02_DOMParsingTest().parseDoc();
	}
}
