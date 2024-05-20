package kr.or.ddit.study08;

public interface ILogin {

	public boolean login(String id, String pass);
	
	public boolean signUp(String id, String pass, String name, String tell);
}
