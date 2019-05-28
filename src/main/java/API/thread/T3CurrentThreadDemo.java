package API.thread;

/**
 * Thread提供了一个静态方法：
 * static Thread currentThread()
 * 该方法可以获取运行这个方法的线程。
 * <p>
 * 后期常用的一个API：ThreadLocal里面就会用到这个方法来实现功能。
 */
public class T3CurrentThreadDemo {

    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println("运行main方法的线程是" + main);
        way();
        Thread t = new Thread() {
            public void run() {
                Thread d = Thread.currentThread();
                System.out.println("自定义线程：" + d);
                way();
            }


        };
        t.start();
    }

    public static void way() {
        Thread t = Thread.currentThread();
        System.out.println("this is in " + t);
    }

}
