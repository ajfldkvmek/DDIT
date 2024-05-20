package kr.or.ddit.study09.exam1;

public class PersonVo {

	String name;
	int age;
	String nation;
	
	public PersonVo(String name, int age, String nation) {
		this.name = name;
		this.age = age;
		this.nation = nation;
	}

	@Override
	public String toString() {
		return "PersonVo [이름=" + name + ", 나이=" + age + ", 국가=" + nation + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) System.out.println("음수는 안되다");
		else this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}	
	
	
}
