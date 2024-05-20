package kr.or.ddit.study08.exam1;

public class ObjectArrayExample2 {
		
	/*
	 * 		String[] stuName = {"홍길동","강감찬","이성계","이순신","정몽주"};
		int[][] score = {{91,83,97,0,0,0},
						{99,99,97,0,0,0},
						{89,87,83,0,0,0},
						{99,99,99,0,0,0},
						{97,79,97,0,0,0}};
	 */
	public static void main(String[] args) {
		
		Student[] std_arr = new Student[5];
		
				
		std_arr[0] = new Student("홍길동", 91, 83, 97, 0, 0, 1);
		std_arr[1] = new Student("강감찬", 99, 99, 97, 0, 0, 1);
		std_arr[2] = new Student("이성계", 89, 87, 83, 0, 0, 1);
		std_arr[3] = new Student("이순신", 99, 99, 99, 0, 0, 1);
		std_arr[4] = new Student("정몽주", 97, 79, 97, 0, 0, 1);
		
		for(int i = 0; i < std_arr.length; i++) {
			std_arr[i].sum = std_arr[i].kor + std_arr[i].eng + std_arr[i].math;
			std_arr[i].aver = Math.round((double) std_arr[i].sum / 3 * 10) / 10.0;
		}
		
		for(int i = 0; i < std_arr.length; i++) {
			for(int j = 0; j < std_arr.length; j++) {
				if(std_arr[i].sum < std_arr[j].sum) std_arr[i].rank++;
			}
		}
		
		for(int i = 0; i < std_arr.length; i++) {
			for(int j = 0; j < std_arr.length; j++) {
				if(std_arr[i].rank < std_arr[j].rank) {
					Student std = new Student();
					std = std_arr[i];
					std_arr[i] = std_arr[j];
					std_arr[j] = std;
				}
			}
		}
		
		for(int i = 0; i < std_arr.length; i++) System.out.println(std_arr[i]);
	}
}

class Student{
	//5명의 3과목(국영수) 성적과 이름을 서언 저장하고 총점 평균과 등수를 출력
	
	String name;
	int kor;
	int math;
	int eng;
	int sum;
	double aver;
	int rank;
	
	public Student(String name, int kor, int math, int eng, int sum, double aver, int rank) {
		super();
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.sum = sum;
		this.aver = aver;
		this.rank = rank;
	}
	

	public Student() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Student2 [name=" + name + ", kor=" + kor + ", math=" + math + ", eng=" + eng + ", sum=" + sum + ", aver="
				+ aver + ", rank=" + rank + "]";
	}
			
}