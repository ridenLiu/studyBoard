package API.thread;
/**
 * 线程提供了一系列获取当前线程信息的方法
 * @author soft01
 *
 */
public class T4ThreadInfoDemo {

	public static void main(String[] args) {
		//获取主线程
		//identify
		Thread main = Thread.currentThread();
		System.out.println(main);
		//获取线程的唯一标示
		long id = main.getId();
		System.out.println("id:"+id);
		
		Thread t = new Thread() {
			public void run() {}
		};
		//获取线程的名字
		String name = main.getName();
		System.out.println("getName:"+name);
		//获取优先级(位数字一到十，默认为五）
		int priority = main.getPriority();
		System.out.println("线程优先级:"+priority);
		//显示是否处于活动状态
		boolean isAlive = main.isAlive();
		//显示是否为守护状态
		boolean isDaemon = main.isDaemon();
		//显示线程是否被中断
		boolean isIntetrupted = main.isInterrupted();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
