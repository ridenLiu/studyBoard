package exercise.date_0115;

import org.junit.jupiter.api.Test;

import java.util.TimerTask;

public class ThreadDemo01 {

    public static void main(String[] args) {
        test1();
        System.out.println("over-----------------------");

    }

    public static void test1(){
        Thread thread1 = new Thread(new Thread01());
        thread1.start();
        System.out.println("over");
    }


}


class Thread01 implements Runnable {

    @Override
    public void run() {
        while (true) {
            //System.out.println("running");
        }

    }
}



