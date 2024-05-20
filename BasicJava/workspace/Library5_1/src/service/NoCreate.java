package service;

import java.util.Random;

public class NoCreate {

	Random rand = new Random();
	
	private static NoCreate instance = null;

	private NoCreate() {
	}

	public static NoCreate getInstance() {
		if (instance == null)
			instance = new NoCreate();
		return instance;
	}

	public String genNo(String str) {
		int rNum = rand.nextInt(99999);
		if(rNum < 10000) rNum += 100000;
		str = str+rNum;
		return str;
	}
	
	public String genNo2(String str) {
		int rNum = rand.nextInt(99999);
		if(rNum < 10000) rNum += 10000;
		str = str+rNum;
		return str;
	}
}
