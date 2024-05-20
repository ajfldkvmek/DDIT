package kr.or.ddit.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 
 * @author PC-06
 *
 * 클래스에 선언된 메소드의 메타정보 가져오기
 * 
 */
public class T03_MethodMetadataTest {

	public static void main(String[] args) {
		Class<?> klass = SampleVO.class;

		//클래스에 선언된 모든 메서드의 메타정보 가져오기
		Method[] methodArr = klass.getDeclaredMethods();
		
		for(Method m : methodArr) {
			System.out.println("메서드명: " + m.getName());
			System.out.println("리턴타입: " + m.getReturnType());
			
			int modFlag = m.getModifiers();
			System.out.println("메서드 접근제어자 정보: "
					+ Modifier.toString(modFlag));
			
			Class<?>[] paramArr = m.getParameterTypes();
			System.out.println("메서드 파라메터 타입: ");
			for(Class<?> clazz : paramArr) {
				System.out.println(clazz.getName() + " | ");
			}
			System.out.println();
			
			Class<?>[] exTypeArr = m.getExceptionTypes();
			System.out.println("메서드 예외 타입: ");
			for(Class<?> clazz : exTypeArr) {
				System.out.println(clazz.getName() + " | ");
			}
			System.out.println();
			
			Annotation[] annos = m.getDeclaredAnnotations();
			System.out.println("Annotation 타입: ");
			for(Annotation anno : annos) {
				System.out.println(anno.annotationType().getName() + " | ");
			}
			System.out.println();
			System.out.println("-----------------------------------------");
		}
	}
}
