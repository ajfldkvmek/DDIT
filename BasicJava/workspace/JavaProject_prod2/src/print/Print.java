package print;

import java.util.List;

import javax.sound.midi.Soundbank;

import vo.Product;
import vo.Cart;

public class Print {

	public void printVar() {
		System.out.println("----------------------------------");
	}

	public void println(int num) {
		for (int i = 0; i < num; i++)
			System.out.println();
	}

	
	public void prindDelete() {
		
	}
	
	public void printDetail(Product product) {
		System.out.println(product.getName());
//		System.out.println(book.getName());
//		System.out.println(book.getName()); ...
		
		
		System.out.println("1. ㅎ");
	}
	
	public void printMemberMenu() {
		printVar();
		System.out.println("1.상품 구매");
		System.out.println("2.구매 내역");
		System.out.println("3.장바구니");
		println(5);
		printVar();
	}
	
	
	public void printSelectMenu() {
		printVar();
		System.out.println("1.이름 수정");
		System.out.println("2.가격 수정");
		System.out.println("3.수량 수정");
		System.out.println("4.설명 수정 ");
		System.out.println("5.전체 수정 ");
		println(2);
		printVar();
	}
	
	public void printHome() {
		printVar();
		System.out.println("1. 관리자"); // 신규등록, 업데이트, 삭제
		System.out.println("2. 일반 회원");
		println(5);
		printVar();
	}

	
	public void printAdminMenu() {
		printVar();
		System.out.println("1. 상품등록"); // 신규등록, 업데이트, 삭제
		System.out.println("2. 상품수정");
		System.out.println("3. 상품삭제");
		println(5);
		printVar();
		
	}
	
	public void printProdList(List<Product> l) {
		printVar();
		System.out.println("번호\t이름\t가격\t수량\t설명");
		for (Product product : l) 
			System.out.println(
					product.getNo()+"\t"+product.getName()+"\t"+product.getPrice()
					+"\t"+product.getCount()+"\t"+product.getText()+"\t");
		println(1);
		printVar();
	}

	public void printBuyList(List<Cart> list) {
		printVar();
		System.out.println("번호\t아이디\t가격\t수량\t");
		for (Cart cart : list) 
			System.out.println(
					cart.getNo()+"\t"+cart.getId()+"\t"+cart.getPrice()
					+"\t"+cart.getCount()+"\t");
		println(1);
		printVar();
	}

	public void printMember() {
		printVar();
		System.out.println("1. 전체 상품 조회");
		System.out.println("2. 홈");
		println(5);
		printVar();
	}

}
