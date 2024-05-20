package service;

import java.util.List;

import dao.BookDAO;
import vo.Book;

public class BookServie {
	
	// 싱글톤 패턴을 만든다.
	private static BookServie instance = null;
	private BookServie() {}
	public static BookServie getInstance() {
		if(instance == null) 
			instance = new BookServie();
		return instance;
	}
	
	// Dao를 부른다 - 테이블 하나당 다오하나
	BookDAO bookdao = BookDAO.getInstance();
	public List<Book> printBookList() {
		return bookdao.bookList();
	}
	public Book bookDetail(int bookNo) {
		return bookdao.bookDetail(bookNo);
	}
	public void bookDel(int delNo) {
		bookdao.bookDelete(delNo);
	}	
}
