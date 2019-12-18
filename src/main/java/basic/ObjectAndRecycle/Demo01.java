package basic.ObjectAndRecycle;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 垃圾回收机制
 * 一. 特征:
 * 1. 垃圾回收只负责回收堆内存中的对象
 * 2. 程序无法精确的控制垃圾回收的机制
 * 3. 垃圾回收在回收任何一个对象之前,都会调用改它的finalize()方法.(该方法可能是该对象重新复活)
 * 二. 对象在内存中的状态:
 * 1. 可达状态: 有引用
 * 2. 可恢复状态: 没引用,finalize()方法未被调用
 * 3. 可回收状态: 没引用,finalize()方法以被调用,但也没有使其重新获得引用.
 */
public class Demo01 {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("gc调用finalize方法! 当前对象: " + this);
    }

    public static void main(String[] args) {
//        forceCallGc();
//        weakReferenceTest();
        phantomReference();
    }

    /**
     * 三: 强制垃圾回收
     * 1. 程序只能控制对象是否有应用但无法控制对象何时被回收
     * 2. 强制垃圾回收的方式:
     * 2.1 调用System的gc()静态方法: System.gc;
     * 2.2 调用Runtime对象的gc()实例方法: Runtime.getRuntime().gc();
     * 这两个方法都只是'通知'系统进行垃圾回收,是否执行不能确定
     * <p>
     * 四: java.lang.Object: protected finalize() throw Throwable 方法
     * 特点:
     * 1. 不要主动调用这个方法,让gc调
     * 2. gc对该方法的调用具有不确定性,所以该方法不一定会执行
     * 3. 该方法可以使对象回到可到达状态
     * 4. 该方法报任何错误,程序都不会报告异常,而且继续执行.
     */
    private static void forceCallGc() {
        System.out.println("begin========");
        for (int i = 0; i < 10; i++) {
            new Demo01();
            System.gc(); // 通知gc回收对象
            // Runtime.getRuntime().gc();

            // 强制垃圾回收机制调用 可恢复对象的finalize()方法
//            System.runFinalization();
            // Runtime.getRuntime().runFinalization();
        }
        System.out.println("over============");
    }

    /**
     * 1. 强引用: StrongReference.常见引用,可达状态,gc不回收
     * 2. 软引用: softReference.可恢复状态,gc可回收.内存充足时,一般不会被回收.适用于对内存敏感的程序.
     * 3. 弱引用: weakReference.可恢复状态,gc可回收.引用级别低于软引用,不管内存是否充足,都在gc回收之列.
     * 4. 虚引用: phantomReference.可恢复状态,gc可回收.类似没有应用,主要用于最终对象垃圾回收的状态,只能和引用队列(ReferenceQueue)联合使用
     * <p>
     * 这些引用都可以使用get()方法获取引用的对象
     */
    private static void weakReferenceTest() {
        String str = new String("Read Death"); // 如果使用直接量,则不会被gc回收,因为会被字符串常量管理(被强引用).
        WeakReference weakRef = new WeakReference(str);
        str = null; // 切断str引用
        // 取出弱引用中的对象
        System.out.println("before gc,weakRef: " + weakRef.get());
        // 强制垃圾回收
        System.gc();
        System.runFinalization();
        // 再次取出应用对象,会被回收
        System.out.println("after gc,weakRef: " + weakRef.get());
    }

    private static void phantomReference() {
        String str = new String("Read Death2");
        ReferenceQueue refQueue = new ReferenceQueue();
        PhantomReference phantomRef = new PhantomReference(str, refQueue);
        str = null; // 断开引用
        // 虚引用获取不到对象
        System.out.println("before gc: " + phantomRef.get());
        // 强制垃圾回收
        System.gc();
        System.runFinalization();
        // 垃圾回收后,虚引用将被放入队列中
        // 取出引用队列中最先进入队列的引用与phantomRef对比
        System.out.println("refQueue.poll() == phantomRef: "+(refQueue.poll() == phantomRef));


    }


}
