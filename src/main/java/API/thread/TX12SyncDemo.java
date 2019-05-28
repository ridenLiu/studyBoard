package API.thread;
/**
 * 静态方法若使用synchronized修饰后，那么一定具有同步修饰效果。
 * @author soft01
 *
 */
public class TX12SyncDemo {

	public static void main(String[] args) {
		final Boo b = new Boo();
		Thread t1 = new Thread() {
			public void run() {
				b.dosome();
				
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				b.dosome();
				
			}
		};
		t1.start();
		t2.start();
	

	}

}
class Boo{
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+" is running dosome");
		try {
		Thread.sleep(5000);
		}catch(Exception e) {}
		System.out.println(t.getName()+" over");
	}
}