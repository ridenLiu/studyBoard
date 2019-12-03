package basic;

public class Demo_wrapperClass {

    public static void main(String[] args) {
        Integer a = 1; // 直接把一个基本类型变量赋值给Integer对象(自动装箱)
        Integer b = Integer.valueOf(1); // 以前的做法
        int c = a; // 将包装类的只直接赋给基本类型变量(自动拆箱)

        Integer e = Integer.parseInt("11"); // 将字符串转化成包装类
    }
}
