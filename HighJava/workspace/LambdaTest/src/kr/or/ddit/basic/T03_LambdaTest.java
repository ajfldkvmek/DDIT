package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface T03_LambdaTest {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("qwe");
		list.add("asd");
		list.add("zxc");
		list.add("123");
		
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("-------------------------------------");
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		System.out.println("-------------------------------------");
		list.forEach( str -> System.out.println(str));
	}
}
