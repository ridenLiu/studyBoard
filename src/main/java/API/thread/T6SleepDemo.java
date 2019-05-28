package API.thread;

import java.util.Scanner;

/**
 * 睡眠阻塞
 * 
 * static void sleep(long ms)
 * 该方法会让运行这个方法的线程处于阻塞状态指定的毫秒，
 * 当超时后，线程会回到RUNNABLE状态，等待再次获取时间片并发运行。
 * 
 * 注：一个线程进入阻塞状态时，CPU会立刻释放并发执行其他线程，
 * 直到该线程接触阻塞状态为止
 * @author soft01
 *
 */
public class T6SleepDemo {

	public static void main(String[] args) {
				/*
				 *  程序起动后输入一个数后，如：100,然后每一秒钟递减一次并输出，到0为止
				 */
		Scanner scan = new Scanner(System.in);
		System.out.println("input:");
		Integer input = Integer.valueOf(scan.nextLine());
		way(input);

	}
	public static void way(int input){
			int bad = 0;
			while(!(input==0)) {
				try {
					long start = System.currentTimeMillis();
					Thread.sleep(1000);
					long end = System.currentTimeMillis();
				if((end-start)!=1000) {
					bad++;
					System.out.println("one bad");
				}
				} catch (InterruptedException e) {e.printStackTrace();}
				System.out.println(input--);
			}
			System.out.println("bad:"+bad);
				
			
	}

}
