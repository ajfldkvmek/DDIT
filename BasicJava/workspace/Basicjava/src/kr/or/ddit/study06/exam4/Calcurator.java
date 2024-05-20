package kr.or.ddit.study06.exam4;

import java.util.StringTokenizer;

public class Calcurator {

    public static void main(String[] args) {

        Calcurator cal = new Calcurator();
        System.out.println(cal.stringCal("13*3/2+3"));        
        System.out.println(cal.callCal(1, 3, '-'));
        
    }

    public double callCal(double a, double b, char op) {    	
    	if(op == '+') return a+b;
    	else if(op == '-') return a-b;
    	else if(op == '/') return a/b;
    	else if(op == '*') return a*b;
    	else return 0;    	
    }
    
    
    public double stringCal(String str) {

        StringTokenizer st1 = new StringTokenizer(str, "1234567890");
        StringTokenizer st2 = new StringTokenizer(str, "*+/-");

        String[] str1 = new String[st1.countTokens()];
        String[] str2 = new String[st2.countTokens()];

//      int count = 0;
        double res = 0;

        int opr = str1.length;
//        int opn = str2.length;

        //operator
        for (int i = 0; st1.hasMoreTokens(); i++) {
            str1[i] = st1.nextToken();
        }

        for (int i = 0; st2.hasMoreTokens(); i++) {
            str2[i] = st2.nextToken();
        }

       //multi & div
        for (int i = 0; i < opr; i++) {

            if (str1[i].equals("*")) {

                double num = Double.valueOf(str2[i]) * Double.valueOf(str2[i + 1]);
                str2[i] = Double.toString(num);

                for (int a = i; a < opr - 1; a++) {
                    String t = str2[a+2];
                    str2[a + 1] = t;
                }

                for (int a = i; a < opr - 1; a++) {
                    String t = str1[a+1];
                    str1[a] = t;
                }

            }

            else if (str1[i].equals("/")) {

                double num = Double.valueOf(str2[i]) / Double.valueOf(str2[i + 1]);
                str2[i] = Double.toString(num);

                for (int a = i; a < opr - 1; a++) {
                    String t = str2[a+2];
                    str2[a + 1] = t;
                }

                for (int a = i; a < opr - 1; a++) {
                    String t = str1[a+1];
                    str1[a] = t;
                }

            }
            else{ continue; }
            opr--;
//            opn--;
            i--;
        }


        //plus & minus
        for (int i = 0; i < opr; i++) {

            if (str1[i].equals("+")) {

                double num = Double.valueOf(str2[i]) + Double.valueOf(str2[i + 1]);
                str2[i] = Double.toString(num);

                for (int a = i; a < opr - 1; a++) {
                    String t = str2[a+2];
                    str2[a + 1] = t;
                }

                for (int a = i; a < opr - 1; a++) {
                    String t = str1[a+1];
                    str1[a] = t;
                }
            }

            else if (str1[i].equals("-")) {

                double num = Double.valueOf(str2[i]) - Double.valueOf(str2[i + 1]);
                str2[i] = Double.toString(num);

                for (int a = i; a < opr - 1; a++) {
                    String t = str2[a+2];
                    str2[a + 1] = t;
                }

                for (int a = i; a < opr - 1; a++) {
                    String t = str1[a+1];
                    str1[a] = t;
                }
            }
            else {continue;}
            opr--;
//            opn--;
            i--;
        }

        res = Double.valueOf(str2[0]);
        return res;
    }

    public double plus(double x, double y) {
        return x + y;
    }

    public double min(double x, double y) {
        return x - y;
    }

    public double multi(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        return x / y;
    }

    public void printCal(double x, double y) {
        System.out.println(x + "+" + y + " = " + plus(x, y));
        System.out.println(x + "-" + y + " = " + min(x, y));
        System.out.println(x + "*" + y + " = " + multi(x, y));
        System.out.println(x + "/" + y + " = " + div(x, y));
    }
}