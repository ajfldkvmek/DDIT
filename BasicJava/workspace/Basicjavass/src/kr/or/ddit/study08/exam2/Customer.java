package kr.or.ddit.study08.exam2;

public class Customer {

	String nation = "한국";
	String id;
	String pw;
	String name;
	int age = 30;
	
//	생성자 만들어주면 기본 생성자는 생성되지 않는다
			
	//동일한 생성자명, 메소드 명에서 파라메터값만 달라지는 것을 오버로딩이라고 한다
	public Customer(String id, String pw, String name, int age) {
//		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		System.out.println("1번 생성자");
	}

	public Customer(String id, String pw, String name) {
		
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
		this(id,pw,name, 30);
		System.out.println("2번 생성자");
	}

	public Customer() {
		System.out.println("기본 생성자");
	}
	
	@Override
	public String toString() {
		return "Customer [nation=" + nation+ ", id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + "]";
	}		
	
}
