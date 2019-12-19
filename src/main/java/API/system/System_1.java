package API.system;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class System_1 {
    /**
     * System类代表当前java程序的运行平台,程序不能创建System对象
     */

    public static void main(String[] args) throws IOException {
//        getEnv();
//        getTime();
        identityHashCodeTest();
    }

    /**
     * 一. 通过System 访问操作环境的环境变量和系统属性
     */
    private static void getEnv() throws IOException {
        Map<String, String> env = System.getenv();
        System.out.println("JAVA_HOME: " + env.get("JAVA_HOME"));
        Properties props = System.getProperties();
        // 本地获取properties文件
        // props.store(new FileOutputStream("D:\\test_board\\props.txt"), "System Properties");
        System.out.println(System.getProperty("os.name"));
    }

    /**
     * 二. 获取当前时间与 UTC 1970-01-01 00:00:00 的时间差
     * 精确程度由底层操作系统决定
     */
    private static void getTime() {
        long millisTime = System.currentTimeMillis();  // 毫秒数
        long nanoTime = System.nanoTime(); // 纳秒数
        System.out.println("millisTime: " + millisTime);
        System.out.println("nanoTime: " + nanoTime);
    }

    /**
     * 三:
     * System.in 标准输入流(键盘)
     * System.out 标准输出流(显示器)
     * System.err 错误输入流
     * 四:
     * 1. System.identityHashCode(Object obj)方法可以返回对象的hashCode值
     * 该值是由对象的内存地址得到的hashCode值.
     * 2. 类实例如果重写hashCode()方法,hashCode()返回结果可能有差别,但IdentityHashCode方法结果不变,
     * 所以如果两个对象的identityHashCode方法返回结果相同,则两对象绝对是同一对象.
     */
    private static void identityHashCodeTest() {
        String s1 = new String("Read_Dead");
        String s2 = new String("Read_Dead");
        // String重写了hashCode()方法,改为根据字符串序列结算hashCode值
        // s1和s2字符串序列相同,这hashCode值相同
        System.out.println("s1_hashcode: " + s1.hashCode());
        System.out.println("s2_hashcode: " + s2.hashCode());
        // s1和s2字符串对象不同,使用identityHashCode得出结果不同
        System.out.println("s1_identityHashCode: "+System.identityHashCode(s1));
        System.out.println("s2_identityHashCode: "+System.identityHashCode(s2));
        // 常量创建字符串,s3和s4指向同一个对象
        String s3 = "wdnmd";
        String s4 = "wdnmd";
        System.out.println("s3_identityHashCode: "+System.identityHashCode(s3));
        System.out.println("s4_identityHashCode: "+System.identityHashCode(s4));

    }
}
