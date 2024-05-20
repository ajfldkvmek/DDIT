import java.util.Random;

public class CommitTest {

	public static void main(String[] args) {

		System.out.println("commit test");
		System.out.println("commit test");
		System.out.println("commit test");
		System.out.println("commit test12");
		
		Random rand = new Random();
		
		int a = rand.nextInt(10000) + 1; //여기서 10000은 0~ 9999의 범위를 말함
		//if(a < 1000) a+=1000; //그냥 단순히 자릿수 맞춰주려고 필수는 아님,
		
		String meet_no = "spo"+a; //여기서는 spo로 했지만 이후 생성 할 때는 카테고리에 맞게 변수명 바꿔주려고...
		
		System.out.println(meet_no);
	}
}
