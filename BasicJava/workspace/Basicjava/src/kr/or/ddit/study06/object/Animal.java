package kr.or.ddit.study06.object;

public class Animal {

	String Species;
	String name;
	boolean fly;
	int lifeSpan;
	int weight;
	int age;
	int remain;
	
	
	public Animal(String species, String name, boolean fly, int lifeSpan, int weight, int age) {
		Species = species;
		this.name = name;
		this.fly = fly;
		this.lifeSpan = lifeSpan;
		this.weight = weight;
		this.age = age;
		
		remain = lifeSpan-age;
	}

	public Animal(Mammalia m, String name, int lifeSpan, int weight, int age) {
		Species = m.species;
		this.name = name;
		this.fly = m.fly;
		this.lifeSpan = lifeSpan;
		this.weight = weight;
		this.age = age;
		
		remain = lifeSpan-age;
	}
	
	@Override
	public String toString() {
		return "Animal [종=" + Species + ", 이름=" + name + ", 날수있니=" + fly + ", 평균수명=" + lifeSpan + ", 몸무게="
				+ weight + ", 나이=" + age + " 남은 기대 수명: " + remain+ "]";
	}
	
	
}
