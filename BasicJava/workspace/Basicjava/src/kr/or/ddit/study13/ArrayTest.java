package kr.or.ddit.study13;

public class ArrayTest {

	private int size = 10;
	private int cur = 0;
	String arr[];
	
	public void add(String s) {
		//arr[cur++] = s;
		if(cur == size) {
			size = size + 10;
			String[] temp = arr.clone();
			arr = new String[size];
			for(int i = 0; i < temp.length; i++) {
				arr[i] = temp[i];
			}
		}
		arr[cur++] = s;
	}
	
	public ArrayTest()	{
		this.arr = new String[size];
	}
	
	public int size() {
		return cur;
	}
	
	public boolean contains(String search) {
				
		for(String s : arr) {
			if(s.equals("str6")) {
				return true;
			}
		}
		return true;
	}
}
