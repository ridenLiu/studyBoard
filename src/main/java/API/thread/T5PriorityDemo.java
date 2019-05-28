package API.thread;
/*
 * 线程优先级
 * 
 * 线程无法主动获取CPU时间片，唯一可以干涉线程调度器工作的方式是修改线程优先级，
 * 最大程度改善获取CPU时间片的几率。
 * 理论上，优先级越高的线程获取CPU时间片的次数越多
 * 线程有10个优先级，依次增大。
 */
public class T5PriorityDemo {

	public static void main(String[] args) {
		final long start = System.currentTimeMillis();
		Thread T1 = new Thread() {
			public void run() {
				for(long i=0;i<100000000000l;i++) {
					long num=100;
					num+=num;
				}
				long end1 = System.currentTimeMillis();
				System.out.println("T1:"+(end1-start));
			}
			
		};
		Thread T2 = new Thread() {
			public void run() {
				for(long i=0;i<100000000000l;i++) {
					long num=100;
					num+=num;
				}
				long end2 = System.currentTimeMillis();
				System.out.println("T2:"+(end2-start));
			}
		};
		Thread T3 = new Thread() {
			public void run() {
				for(long i=0;i<100000000000l;i++) {
					long num=100;
					num+=num;
				}
				long end3 = System.currentTimeMillis();
				System.out.println("T3:"+(end3-start));
			}
		};
		T1.setPriority(Thread.MAX_PRIORITY);
		T2.setPriority(Thread.MIN_PRIORITY);
		T3.start();
		T2.start();
		T1.start();
		
	}

}
