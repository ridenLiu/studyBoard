package API.thread;
/**
 * 线程
 * 线程可以并发执行多段代码，给我们感觉上这些代码在“同时运行“
 * 创建线程有两种方式：
 * 一：继承Thread并重写run方法。
 * 二：
 * @author soft01
 *
 */
public class T1ThreadDemo1 {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		
		
	}
	/**
	 * 第一种创建线程的方式存在两个不足之处
	 * 
	 * 1：由于java是单继承的，这导致继承了Thread后就不能再继承其他类了。
	 * 在实际开发中经常会继承某个超类来复用其中的方法，这导致两者不能同时继承。
	 * 
	 * 2：继承线程后重写run方法来定义任务，这又导致我们将任务直接定义在任务上，
	 * 使得线程只能做该任务，无法执行其他任务，代码重用性差。
	 */
	
	

}
class Thread1 extends Thread{
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("有有有有有有有有有有有有有有有有");
		}
	}
}

class Thread2 extends Thread{
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("bbbbbbbbbbbbbbbbbbbbb");
		}
	}
}

