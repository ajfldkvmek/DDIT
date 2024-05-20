package lambda;

@FunctionalInterface
interface MyFunction { // 함수형 인터페이스
    int calc(int x, int y); // 추상 메소드
}
 


public class LambdaEx {
    
    public LambdaEx() {
        
        MyFunction f1 = (x, y) -> {return x+y;};
        System.out.println("f1의 결과: " + f1.calc(22, 100));
        
        MyFunction f2 = (x, y) -> {return x-y;};
        System.out.println("f2의 결과: " + f2.calc(99, 9));
    }
 
    public static void main(String[] args) {
        new LambdaEx(); 
    }
 
}