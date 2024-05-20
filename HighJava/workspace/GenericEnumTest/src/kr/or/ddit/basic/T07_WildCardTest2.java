//package kr.or.ddit.basic;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class T07_WildCardTest2 {
//
//	//장바구니- 항목조회를 위한 메서드(모든 항목)
//	public static void displayCartItemInfo(Cart<?> cart) {
//		System.out.println("===========장바구니 항목 리스트=========");
//		for(Object obj : cart.getList()) {
//			System.out.println(obj);
//		}
//		System.out.println("----------------------------------");
//	}
//	
//	//장바구니- 항목조회를 위한 메서드(음료류 항목담은 ~ )
////	public static void displayCartItemInfo2(Cart<? extends Drink> cart) {
//	public static void displayCartItemInfo2(Cart<Food> cart) {
//		System.out.println("===========장바구니 항목 리스트	=========");
//		for(Object obj : cart.getList()) {
//			System.out.println(obj);
//		}
//		System.out.println("----------------------------------");
//	}
//	
//	//장바구니- 항목조회를 위한 메서드(고기류 항목담은 ~ )
////	public static void displayCartItemInfo3(Cart<? extends Meat> cart) {
//	public static void displayCartItemInfo3(Cart<Food> cart) {
//		System.out.println("===========장바구니 항목 리스트	=========");
//		for(Object obj : cart.getList()) {
//			System.out.println(obj);
//		}
//		System.out.println("----------------------------------");
//	}
//	
//	public static void main(String[] args) {
//	
//		Cart<Food> foodCart = new Cart<>();
//		foodCart.addItem(new Meat("돼지", 5000));
//		foodCart.addItem(new Meat("소", 500000));
//		foodCart.addItem(new Juice("오렌지쥬스", 3000));
//		foodCart.addItem(new Coffee("아메리카노", 2000));
//		
//		Cart<Food> meatCart = new Cart<>();
//		meatCart.addItem(new Meat("돼지", 5000));
//		meatCart.addItem(new Meat("소", 500000));
////		meatCart.addItem(new Juice("오렌지쥬스", 3000));
////		meatCart.addItem(new Coffee("아메리카노", 2000));
//		
//		Cart<Food> drinkCart = new Cart<>();
////		meatCart.addItem(new Meat("돼지", 5000));
////		meatCart.addItem(new Meat("소", 500000));
//		drinkCart.addItem(new Juice("오렌지쥬스", 3000));
//		drinkCart.addItem(new Coffee("아메리카노", 2000));
//		
//		
//		displayCartItemInfo(foodCart);
//		displayCartItemInfo(meatCart);
//		displayCartItemInfo(drinkCart);
//		
////		displayCartItemInfo2(foodCart);
////		displayCartItemInfo2(meatCart);
//		displayCartItemInfo3(drinkCart);
//		
//		displayCartItemInfo3(foodCart);
//		displayCartItemInfo3(meatCart);
//		displayCartItemInfo3(drinkCart);
//	}
//}
//
//
//class Food {
//	private String name;
//	private int price;
//	
//	public Food(String name, int price) {
//		super();
//		this.name = name;
//		this.price = price;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	@Override
//	public String toString() {
//		return "이름: " + name + ", 가격: " + price;
//	}
//}
//
//class Meat extends Food {
//
//	public Meat(String name, int price) {
//		super(name, price);
//	}
//}
//
//class Drink extends Food {
//
//	public Drink(String name, int price) {
//		super(name, price);
//	}
//}
//
//class Juice extends Drink {
//
//	public Juice(String name, int price) {
//		super(name, price);
//	}
//}
//
//class Coffee extends Drink {
//
//	public Coffee(String name, int price) {
//		super(name, price);
//	}
//}
//
//class Cart<T> {
//	private List<T> list;
//	
//	public Cart() {
//		list = new ArrayList<T>();
//	}
//
//	public List<T> getList() {
//		return list;
//	}
//
//	public void addItem(T item) {
//		list.add(item);
//	}
//}
//
//
//
