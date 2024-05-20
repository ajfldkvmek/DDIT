package kr.or.ddit.study06.exam1;

import java.util.Scanner;

public class ObjectArrayExample {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ObjectArrayExample obj = new ObjectArrayExample();
		obj.method1();
		
	}

	private void method1() {
		
		Book book = new Book();
		book.price = 1000;
		book.title = "자바";
		book.writter = "신용권";		
		System.out.println(book);
		
		Book book2 = new Book();
		book2.price = 1100;
		book2.title = "파이썬";
		book2.writter = "양형운";		
		System.out.println(book2);
		
		Book[] book3 = new Book[2];
		
		book3[0] = book;
		book3[1] = book2;
		for(int a = 0; a < book3.length; a++) {
			System.out.println(book3[a]);
		}
	}	
	
}

class Book {
	
	String title;
	String writter;
	int price;
	
	@Override
	public String toString() {
//		return "Book [title=" + title + ", writter=" + writter + ", price=" + price + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		return "Book [title=" + title + ", writter=" + writter + ", price=" + price + "]";
	}
}