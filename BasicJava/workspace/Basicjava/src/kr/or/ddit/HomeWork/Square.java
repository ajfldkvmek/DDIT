package kr.or.ddit.HomeWork;

public class Square {

    int x;
    int y;

    double right;
    double left;
    double bottom;
    double top;

    public static void main(String[] args) {
        //첫 번째 사각형에 나머지 두 개의 사각형이 포함되었는지 여부를 판단할 수 있는 메서드를 포함시키시오.
        //s1이 기준
        Square s1 = new Square();
        Square s2 = new Square();
        Square s3 = new Square();

        s1.paintSquare(1, 1, 1, 1);
        s2.paintSquare(0, 0, 3, 3);
        s3.paintSquare(7, 8, 3, 2);

        isIn(s1, s2);
    }

    //사각형 가로 세로 (x, y) 좌표 받아서 그리기
    public void paintSquare(int x, int y, double row, double col) {
        this.x = x;
        this.y = y;

        double l = row/2;
        double c = col/2;

        right = x + l;
        left = x - l;
        bottom = y - c;
        top = y + c;

    }

//    public boolean inRow(Square s1, Square s2){
//
//        boolean b = false;
//
//        if(s1.x > s2.x){
//            if(s1.x > s2.x){
//                if(s1.left < s2.right) b =true;
//            }
//
//            else if(s1.x < s2.x){
//                if(s1.right > s2.left) b = true;
//            }
//            else {
//                b = true;
//            }
//        }
//        return b;
//    }
//
//    public boolean inCol(Square s1, Square s2){
//
//        boolean b = false;
//
//        if(s1.y > s2.y) {
//            if(s1.bottom < s1.top) b = true; // s1의 바닥이 s2의 top 보다 낮으면 겹침
////            else b = false;
//        }
//        else if(s1.y < s2.y){
//            if(s1.top > s2.bottom) b = true;
////            else b = false;
//        }
//        else {
//            b = true;
//        }
//        return b;
//    }
//
//    public static void isIn(Square s1, Square s2){
//
//        Square s = new Square();
//
//        boolean incol = s.inCol(s1, s2);
//        boolean inrow = s.inRow(s1, s2);
//
//        //둘다 참이면 겹침
//        if(incol && inrow) System.out.println("겹쳐요");
//        else System.out.println("안겹쳐요");
//    }


    public static void isIn(Square s1, Square s2) {

        boolean c = false; //겹치면 true
        boolean r = false;

        if(s1.y == s2.y) c = true;

        else if(s1.y > s2.y) {
            if(s1.bottom < s2.top) {
                c = true;
            }
        }
        else {
            if(s1.top > s2.bottom){
                c = true;
            }
        }

        if(s1.x == s2.x) r = true;
        else if(s1.x > s2.x){
            if(s1.left < s2.right) r =  true;
        }
        else{
            if(s1.right > s2.left) r = true;
        }
        
        if(c && r) System.out.println("겹쳐요");
        else System.out.println("안겹쳐요");
    }
}