package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Random;

public class HorseRace {

    static int CURRENT_RANK = 1;

    public static void main(String[] args) {

        List<Horse> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(new Horse(i + "번말"));
        }

        for (Thread th : list) {
            th.start();
        }

        for (Thread th : list) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("경기끝...");

        Collections.sort(list);

        System.out.println("------------------------");
        System.out.println("경기결과");
        System.out.println("========================");
        System.out.println("순위\t:\t이름");
        System.out.println("========================");
        for (Horse dp : list) {
            System.out.println(dp.getRank() + "\t:\t" + dp.getName());
        }
    }
}

class Horse extends Thread implements Comparable<Horse> {

    private static final int TRACK = 50;
    private String name;
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Horse(String name) {
        super(name); // 스레드 이름 지정
        this.name = name;
    }

    public void run() {
//        Random rand = new Random();
        synchronized (this) {
            for (int a = 0; a < TRACK; a++) {
                runTrack(name, a);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name + "도착");
        this.setRank(HorseRace.CURRENT_RANK++);
    }

    synchronized public void runTrack(String name, int a) {
        char[] ch = new char[TRACK];
        String str = "";
        for (int b = 0; b < TRACK; b++) {
            if (a == b)
                ch[b] = '>';
            else
                ch[b] = '-';
        }
        str = String.valueOf(ch);
        System.out.println(name + ": " + str);
    }

    @Override
    public int compareTo(Horse dp) {
        return Integer.compare(this.getRank(), dp.getRank());
    }
}
