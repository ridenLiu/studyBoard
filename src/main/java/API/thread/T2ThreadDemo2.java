package API.thread;
/**
 * 第二种创建线程的方法：
 * 实现Runnable接口，单独定义线程任务。
 * @author soft01
 *
 */
public class T2ThreadDemo2 {

	public static void main(String[] args) {
		//实例化任务
		Runnable r1 = new Test();
		Runnable r2 = new Test2();
		//创建线程
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		//start
		t1.start();
		t2.start();

	}

}
class Test implements Runnable{

	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("++++++++");
		}
		
	}
}
class Test2 implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("缇缇缇缇缇");
		}
	}
}








