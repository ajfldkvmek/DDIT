package kr.or.ddit.study07.test;

public class FountainPen extends Ballpen{

	private int amount;
	private String color;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void refill(int n) {
		setAmount(n);
	}
	
}
