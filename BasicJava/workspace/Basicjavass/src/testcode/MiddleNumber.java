package testcode;
/*N이 9 이고, 9개의 점수가 아래와 같이 주어질 경우,

85 72 38 80 69 65 68 96 22

69이 중간값이 된다.


[제약 사항]

1. N은 항상 홀수로 주어진다.

2. N은 9이상 199 이하의 정수이다. (9 ≤ N ≤ 199)
*/
import java.util.Arrays;
import java.util.Scanner;

public class MiddleNumber {

	static void middle () {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int [] arr = new int[N];
		
		int temp = Integer.MIN_VALUE;
		
		for(int a = 0; a < N; a++) {
			arr[a] = sc.nextInt();	
			if(temp <= arr[a]) temp = arr[a];	
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[N/2]);
		
		sc.close();
	}
	
}
