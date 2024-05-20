package kr.or.ddit.HomeWork;

public class Tv {
	
	//문제 2 – main 메서드에서 실행시켰을 때 제조사, 생산년도, 크기를 출력하는 Tv클래스를 생성하시오.

	String brand = "";
	String date = "";
	int size;
	
	public static void main(String[] args) {
		
		Tv tv = new Tv();
		tv.setBrand("삼성");
		tv.setSize(100);
		tv.setDate("202307");
		tv.print();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Tv 제조사: " + brand + ", 제조년월: " + date + ", 크기: " + size + "이다";
	}
	
	public void print() {
		System.out.println(toString());
	}
	
}
