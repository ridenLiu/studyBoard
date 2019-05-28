package API.thread;
/**
 * 当一个线程调用Sleep方法处于阻塞状态时，其他线程调用该线程的中断方法时，
 * 那么该线程的sleep方法会立即抛出中断异常并打断睡眠阻塞。
 * @author soft01
 *
 */
public class T7SleepDemo2 {

	public static void main(String[] args) {
		/*
		 * JDK1.8之前，有一个要求，即：
		 * 当一个方法中的局部内部类想引用 这个方法的其他局部变量，那么这个变量必须是final修饰的。
		 * 好比main方法中的局部内部类T2中的run方法里引用了main方法的局部变量T1，那么这个变量就
		 * 必须声明为final的
		 */
		final Thread T1 = new Thread() {
			public void run() {
				/*
				 * 当一个线程调用sleep阻塞时，被其他线程中断会抛出中断异常
				 */
				System.out.println("begin sleep");
				try {
					Thread.sleep(100000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					System.out.println("T1 was interrupetde");
				}
			}
		};
		Thread T2 = new Thread() {
			public void run() {
				System.out.println("T2 begin to interrupt!");
				T1.interrupt();
				System.out.println("over");
			}
		};
		T1.start();
		T2.start();

	}

}
