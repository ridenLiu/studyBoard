package API.thread;
/**
 * 同步块
 * 有效性缩小同步范围可以再保证并发安全的前提下尽可能的提高并发效率。
 * 
 * 语法：
 * synchronized(同步监视器对象){
 * 需要同步运行的代码片
 * }
 * @author soft01
 *
 */
public class TX11SyncDemo2 {
		public static void main(String[]args) {
			final Shop shop = new Shop();
			Thread t1 = new Thread() {
				public void run() {
					shop.buy();
				}
			};
			Thread t2 = new Thread() {
				public void run() {
					shop.buy();
				}
			};
			t1.start();
			t2.start();
		}
}
		class Shop{
			//public synchronized void buy()
			/**
			 * 直接在方法上使用synchronized，那么同步监视器对象就是当前方法所属对象，
			 * 即：方法中看到的this。
			 */
			public void buy(){
				try {
					Thread t = Thread.currentThread();
					System.out.println(t.getName()+" is chooing clothes");
					Thread.sleep(5000);
					
					synchronized(this) {
					System.out.println(t.getName()+" is testing clothes");
					Thread.sleep(5000);
					/*
					 * 同步块有一个要求，多个线程看到的同步监视器对象必须是同一个！
					 * 否则没有同步运行效果。
					 * 具体使用那个对象结合实际开发需求而定。
					 */
					}
					System.out.println("over");
					
				}catch(Exception e) {};
			}
		}
