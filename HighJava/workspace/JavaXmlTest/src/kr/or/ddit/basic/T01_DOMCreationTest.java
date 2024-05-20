package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;

//import javax.naming.spi.DirStateFactory.Result;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 
 * 
 * xml을 이용한 문서새성성예제
 * 
 */

public class T01_DOMCreationTest {

	/*
	 * DOM표준 DOM은 문서에 접근하는 표준방법으로서, 이를 이용함녀 플랫폼 및 개발언어에 독립적으로 문서의 내용, 구조 및 스타일 정보를
	 * 동적으로 핸들링 할 수 있다
	 * 
	 * W3C DOM 표준은 다음과 같이 크게 3가지로 나우어 볼 수 있다.
	 * 
	 * Core DOM - 모드 문서타입을 위한 핵심표준 모델(API) XML DOM - XML문서를 위한 표준 모델 HTML DOM -
	 * HTML문서를 위한 표준 모델
	 * 
	 * 예를 들면, HTML DOM은 HTML엘리먼트 요소 및 속성 정보를 핸들링 하기위한 인터페이스를 제공한다
	 */

	public void createDoc() throws ParserConfigurationException, TransformerConfigurationException {
		// XML << 파일 용량이 커짐
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();

		// Document 객체 생성
		Document document = builder.newDocument();

		// root 엘리먼트 생성
		Element rootEl = document.createElement("root");

		// booklist 엘리먼트 생성
		Element bookListEl = document.createElement("booklist");

		// book 엘리먼듵 생성
		Element bookEl = document.createElement("book");
		bookEl.setAttribute("isbn", "b001");
		bookEl.setAttribute("kind", "java");

		// 자식 엘리멘트
		Element titleEl = document.createElement("title");
		titleEl.setTextContent("JAVA초급");
		Element authorEl = document.createElement("author");
		authorEl.setTextContent("이순신");
		Element priceEl = document.createElement("price");
		priceEl.setTextContent("25000");

		bookEl.appendChild(titleEl);
		bookEl.appendChild(authorEl);
		bookEl.appendChild(priceEl);

		bookListEl.appendChild(bookEl);

		// ----------------------------------------------------------

		// book 엘리먼듵 생성
		bookEl = document.createElement("book");
		bookEl.setAttribute("isbn", "b002");
		bookEl.setAttribute("kind", "java");

		// 자식 엘리멘트
		titleEl = document.createElement("title");
		titleEl.setTextContent("JAVA고급");
		authorEl = document.createElement("author");
		authorEl.setTextContent("홍길동");
		priceEl = document.createElement("price");
		priceEl.setTextContent("35000");

		bookEl.appendChild(titleEl);
		bookEl.appendChild(authorEl);
		bookEl.appendChild(priceEl);

		bookListEl.appendChild(bookEl);

		// ----------------------------------------------------------

		// book 엘리먼듵 생성
		bookEl = document.createElement("book");
		bookEl.setAttribute("isbn", "b003");
		bookEl.setAttribute("kind", "db");

		// 자식 엘리멘트
		titleEl = document.createElement("title");
		titleEl.setTextContent("DB설계");
		authorEl = document.createElement("author");
		authorEl.setTextContent("일지매");
		priceEl = document.createElement("price");
		priceEl.setTextContent("38000");

		bookEl.appendChild(titleEl);
		bookEl.appendChild(authorEl);
		bookEl.appendChild(priceEl);

		bookListEl.appendChild(bookEl);

		// ----------------------------------------------------------

		// book 엘리먼듵 생성
		bookEl = document.createElement("book");
		bookEl.setAttribute("isbn", "b004");
		bookEl.setAttribute("kind", "db");

		// 자식 엘리멘트
		titleEl = document.createElement("title");
		titleEl.setTextContent("DB구현");
		authorEl = document.createElement("author");
		authorEl.setTextContent("강감찬");
		priceEl = document.createElement("price");
		priceEl.setTextContent("42000");

		bookEl.appendChild(titleEl);
		bookEl.appendChild(authorEl);
		bookEl.appendChild(priceEl);

		bookListEl.appendChild(bookEl);

		// ----------------------------------------------------------

		// 루트엘리먼트에 booklist추가하기
		rootEl.appendChild(bookListEl);

		// 도큐먼트에 root엘리먼트 추가하기
		document.appendChild(rootEl);

		////////////////////// 문서작성 종료///////////////////////

		// XML문서 변환기 생성하기
		TransformerFactory transformfactory = TransformerFactory.newInstance();
		Transformer transformer = transformfactory.newTransformer();

		// 출력인코딩 설정
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

		// 들여쓰기 절정
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		//xml 문서 변환 작업
		DOMSource domSource = new DOMSource(document);
		StreamResult result = new StreamResult();
		
		//파일에 문서 저장하기
		FileOutputStream fos = null;
		try {
			fos= new FileOutputStream("./src/new_book.xml");
			result.setOutputStream(fos);
			transformer.transform(domSource, result); // 변환 시작
		} catch(IOException ex) {
			ex.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("문서 생성 작업 종료");
	}
	
	
	public static void main(String[] args) throws TransformerConfigurationException, ParserConfigurationException {
		
		new T01_DOMCreationTest().createDoc();
	}
}
