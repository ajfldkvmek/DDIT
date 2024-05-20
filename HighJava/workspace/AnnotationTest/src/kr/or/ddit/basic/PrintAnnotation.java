package kr.or.ddit.basic;
/*
 *  Annotation에 대하여
 *  프로그램 소스코드 안에 다른 프로그렘을 위한 정보를 미리 약속된 형식으로 포함시킨것(jdk1.5부터 지원)
 *  주석처럼 프로그램에 영향을 미치지 않으면서도 정보를 전달 할 수 있음 (ex. @overriding)
 *  
 *  종류 :
 *  1.표준(일반) annotation	
 *  2.메타 annotation		  	(어노테이션을 위한 어노테이션>> 어노테이션 정의 할 때 사용)
 *  
 *  어노테이션정의
 *  @interface name {
 *  	요소타입 요소이름(); 반환타입 있고 매개변수 없음(추상메서드 형태)
 *  }
 *  
 *  어노테이션 요소의 규칙
 *  1.요소타입은 기본형, String, enum, annotation, class 만 허용
 *  2.()안에 매개변서 x
 *  3.예외 선언 x
 *  4.요소타입에 제네릭타입글자x
 *  
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//메타 어노테이션 target, retention
//@Target({ElementType.METHOD, ElementType.TYPE})			//적용대상
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)	//유지기간
//PrintAnnotationTest라는 어노테이션을 선언
public @interface PrintAnnotation {
	int id = 100;	//상수선언가능
	String value() default "-"; //기본을 -로 지정
	int count() default 20;
}

