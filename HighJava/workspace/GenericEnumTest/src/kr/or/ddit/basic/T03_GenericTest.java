package kr.or.ddit.basic;

/*
 * 	제네릭 클래스를 선언하는 방법
 *  class classname<?> {?는 제네릭타입 글자 (T, K, V, E)
 *  	제네렉타입글자 메서드 명() {
 *  		반환값이 있는 메서드에서 사용
 *  		return;
 *  	}
 *  } 
 *  T: type		타입
 *  K: key 		키
 *  V: value 	값
 *  E: element	자료구조에 들어가는 항목을 나타낼 때
 */ 

class NoneGenericClass {
	private Object var;

	public Object getVar() {
		return var;
	}

	public void setVar(Object var) {
		this.var = var;
	}
}

class GenericClass<T> {
	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
}

public class T03_GenericTest {

	public static void main(String[] args) {
		NoneGenericClass ng1 = new NoneGenericClass();
		ng1.setVar("가나다라");
		NoneGenericClass ng2 = new NoneGenericClass();
		ng2.setVar(100);
		
		String rtnVal1 = (String) ng1.getVar();
		System.out.println(rtnVal1);
		
		Integer rtnVal2 = (Integer) ng2.getVar();
		System.out.println(rtnVal2);
		
		GenericClass<String> gc1 = new GenericClass<String>();
		GenericClass<Integer> gc2 = new GenericClass<Integer>();
		
		gc1.setVar("우리나라");
		gc2.setVar(500);
		
		rtnVal1 = gc1.getVar();
		rtnVal2 = gc2.getVar();
		
		System.out.println(rtnVal1);
		System.out.println(rtnVal2);
	}
	
}




















