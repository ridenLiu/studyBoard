package API.thread;
/*
 * 守护线程
 * 
 * 守护线程又称为后台线程，默认创建出来的线程都是普通线程或前台线程。
 * 只有调用线程的setDeamon方法后才会将线程设置为守护线程。
 * 
 * 守护线程使用上与前台线程一样，但是在结束时机上有一点不同：
 * 当进程结束后，所有进行的守护线程都会被强制中断。
 * 进程的结束：当一个进程中没有任何前台进程时即结束。
 */
public class T8DeamonThreadDemo {

	public static void main(String[] args) {
		Thread T1 = new Thread() {
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("T1 is running-=-=-=-=-=-=-=-");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("T1 is done");
			}
			
		};
		Thread T2 = new Thread() {
			public void run() {
				while(true) {
					System.out.println("T2 is running");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		T1.start();
		/*
		 * 设置守护线程必须得在start方法之前。
		 */
		T2.setDaemon(true);
		T2.start();
		System.out.println("main is over!");

	}

}
