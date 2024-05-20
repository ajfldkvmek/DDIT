package test;

public class StringBuilderTest {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 50000; i++) {
			sb.append("A");
		}
		System.out.println(sb);
		}
}
