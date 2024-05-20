package kr.or.ddit.reflection;

/**
 	Class 오브젝트를 생성
 */
public class T01_ClassObjectCreation {

	/*
	 *  java relection에 대하여
	 *  
	 *  1.리플렉션은 런타임 시점에 클래스 또는 멤버변수, 메서드, 생성자 등에 대한 정보를
	 *    가져오거나 수정할 수 있고 새로운 객체를 생성하거나 메서드를 실행할 수 있다.
	 *    (컴파일 시점에 해당 정보를 알 수 없는 경우(소스코드부재) 유용하게 사용할 수 있음
	 *    
	 *  2.Reflection API는 java.lang.reflect 패키치와
	 *  				  java.lang.Class 를 통해 제공된다
	 *  
	 *  3. java.lang.Class의 주요 메서드
	 *  	-getName, getSuperClass getInstance, getModifiers 등
	 *  
	 *  4. java.lang.reflect 패키지의 주요 클래스
	 *  	-Field, Method, Constructor, Modifier
	 */
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException {
		
		//첫번째 방법: Class.forName() 메서드 이용하기
		//패키지이름까지 다 써야함
		Class<?> cla = Class.forName("kr.or.ddit.relection.T01_ClassObjectCreation");
		
		//두번째 방법: getClass() 메서드 이용하기 ( classname을 알 때)
		T01_ClassObjectCreation coct = new T01_ClassObjectCreation();
		cla = coct.getClass();
		
		//세번째 방법: .class (이거도 classname 알 떄)
		cla = kr.or.ddit.reflection.T01_ClassObjectCreation.class;
	}
}
