package API.thread;
/**
 * join方法可以协调线程之间的同步运行
 * 
 * 异步运行：代码之间没有先后顺序，各干各地。
 * 同步运行：代码之间有先后顺序。
 * @author soft01
 *
 */
public class T9JoinDemo {
		//标示图片是否下载完毕
	public static boolean isFinish = false;
	
	public static void main(String[] args) {
				final Thread download = new Thread() {
					public void run() {
						System.out.println("down:开始下载图片...");
						
						for(int i=1;i<=100;i++) {
							System.out.println("正在下载，已完成："+i+"%");
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {}
							
						}
						System.out.println("图片下载完成");
						isFinish = true;
					}
				};
				Thread show = new Thread() {
					public void run() {
						System.out.println("show:开始显示图片...");
						/*
						 * 先等待下载线程将图片下载完毕
						 */
						try {
							/*
							 * 当show线程调用download线程的join方法后就进入了阻塞状态，
							 * 直到sownload线程结束后才会结束阻塞。
							 */
							download.join();
						} catch (InterruptedException e) {}
						if(!isFinish) {
							throw new RuntimeException("图片加载失败！");
						}
						System.out.println("show:图片显示成功！");
					}
				};
				download.start();
				show.start();

	}

}
