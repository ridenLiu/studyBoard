package basic;


public class Demo_equals {

    public static void main(String[] args) {
        stringInit();

    }

    /**
     * ==和equals是判断两个变量是否相等的两种方式.
     * 1. ==:
     * 1.1 如果两个变量是基本类型,却都是数值类型(不一定要求两种类严格相同),则只要两个变量的值相等时返回true
     * 1.2 如果是应用类型变量,这只有当他们指向同一个对象时,==判断才返回true
     * 2. equals:
     */
    static void test1() {
        int a = 1;
        short b = 1;
        long c = 1;
        System.out.println(a == c);// true,基本类型,数值类型相等即可
        System.out.println(a == b);// true
    }

    /**
     * "hello"直接量(包括编译时就能计算出来的字符串值)和new String("hello");
     * 1. "hello"直接量,JVM会使用常量池管理这些字符串.
     * 2. new String("hello"),JVM首先会使用常量池来管理"hello"直接量,在调用String的构造器来创建
     * 一个新的String对象,所以new String("hello")会创建两个对象(前提是常量池中没有"hello").
     * 3. 常量池: 专门用于保存在编译时被确定并保存在.class文件中的一些数据.它包含类,方法,接口中
     * 的常量,还包括字符串常量.
     * 4. JVM常量池保证相同的字符串直接量只有一个,不会有多个副本,所以例子中s3,s4,s5都引用常量池中
     * 同一个对象.使用new String()创建的字符串对象是运行时创建的,它会被保存的内存中,不会放如常量池.
     */
    static void stringInit() {
        String str1 = "你好";
        String str2 = "世界";
        String str3 = "你好世界";

        String str4 = "你好" + "世界";
        // true,因为直接量编译时就确定结果了,s4直接引用常量池中的"你好世界"
        System.out.println(str4 == str3);
        // false,由于有变量,不能在编译时就确定结果,无法引用常量池
        String str5 = str1 + str2;
        System.out.println(str5 == str3);
        // false,调用构造器会创建新的String对象
        String str6 = new String("你好世界");
        System.out.println(str6 == str3);

    }
}
