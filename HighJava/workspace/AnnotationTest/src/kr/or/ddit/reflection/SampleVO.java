package kr.or.ddit.reflection;

import java.io.Serializable;

import kr.or.ddit.basic.PrintAnnotation;

@SuppressWarnings("serial")
public class SampleVO implements Serializable{

	private String id;
	protected String name;
	public int age;
	
	public SampleVO() {
		super();
	}

	public SampleVO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	//deprecated<< 비추천한다는 말
	@Deprecated
	@PrintAnnotation
	public String getId() throws Exception{
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SampleVO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
