package API.thread;
/**
 * 互斥锁
 * 当synchronized同时锁定多段代码时，并且它们指定的同步监视器
 * 对象(就是当前方法的所属对象）
 * 是【同一个】时，那么这些代码之间就是互斥对，
 * 即：多个线程不能同时执行这些代码。
 * @author soft01
 *
 */
public class TX13SyncDemo4 {

	public static void main(String []args) {
		final Foo foo = new Foo();
		final Foo foo2 = new Foo();
		Thread t1 = new Thread() {
			public void run() {
				foo.methodA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				foo2.methodB();
			}

		};
		t1.start();
		t2.start();
	}
}
class Foo{
	public synchronized void methodA() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"is Running !");
			Thread.sleep(5000);
			System.out.println(t.getName()+"is over");
		}catch(Exception e) {}
	}
	public synchronized void methodB() {
		try {
			Thread f = Thread.currentThread();
			System.out.println(f.getName()+"is Running!");
			Thread.sleep(5000);
			System.out.println(f.getName()+"is over");
		}catch(Exception e) {}
	}
}
