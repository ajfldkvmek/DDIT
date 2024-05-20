package kr.or.ddit.study07;

public class PhoneExample {

	public static void main(String[] args) {
		Phone p = new Phone();
		p.tell();
		
		System.out.println("------------fp------------");
		FolderPhone fp = new FolderPhone();
		fp.folding();
		fp.tell();
		fp.camera();
		
		System.out.println("------------sp------------");
		SmartPhone sp = new SmartPhone();
		sp.internet();
		sp.touch();
		sp.tell();
		sp.camera();
	}
	
}
