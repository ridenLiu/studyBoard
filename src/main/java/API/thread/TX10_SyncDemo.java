package API.thread;
/**
 * 多线程并发的安全问题
 * 当多线程并发操作同一资源时，由于线程切换时机的不确定和不可控，
 * 会导致操作该资源的代码逻辑执行顺序未按照设计要求运行，
 * 出现了混乱操作。严重时可能导致系统瘫痪。
 * @author soft01
 *
 */
public class TX10_SyncDemo {

	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
		

		
	}

}
	class Table{
		//beans
		private int beans = 20;
		/**synchronized
		 * 解决并发安全问题的核心就是将多个线程抢着运行改为有先后运行顺序的排队进行。
		 * java提供了锁机制，强制多个方法同步运行一个方法
		 * 
		 * 当一个方法上使用关键字：synchronized修饰后，该方法称为同步方法，
		 * 多个方法不能同步在方法内部运行。
		 * @return
		 */
		public synchronized int getBean() {
			if(beans==0) {
				throw new RuntimeException("There have no beans");
			}
			Thread.yield();
			/*
			 * yield方法会让运行这个方法的线程立刻让出CPU时间
			 * 在这里是为了迷你发生线程切换。
			 */
			return beans--;
		}
	}
