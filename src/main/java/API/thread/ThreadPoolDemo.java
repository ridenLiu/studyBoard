package API.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池是一个管理线程的机制.它主要解决两个问题:
 * 1:重用线程
 * 2:控制线程数量
 * 频繁的创建和销毁线程会给系统带来额外的开销,所以线程应当重用
 * 当线程数量过多时,会出现资源消耗增大,CPU出现过度切换导致
 * 并发行降低,对此线程的数量也要得以控制在当前硬件环境所能承受的范围内.
 *
 * @author soft01
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadpool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            Runnable run = new Runnable() {
                public void run() {
                    //创建一个线程
                    Thread t = Thread.currentThread();
                }
            };
            //将任务交给线程池(execute<执行>)
            threadpool.execute(run);
            //当线程完成给定任务后结束线程池
            //threadpool.shutdown();
            //让线程池立即结束
            //threadpool.shutdownNow();

        }
    }
}