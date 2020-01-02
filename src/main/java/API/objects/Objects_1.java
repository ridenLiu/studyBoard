package API.objects;

import java.util.Objects;

public class Objects_1 {
    /**
     * java为工具类的明名习惯为添加一个字母"s",不如数组的工具类为Arrays,集合的是Collections
     * Objects类
     *
     */
    public static void main(String[] args) {
        test1();
    }
    /**
     * 一. 该工具类大多数都是"空指针"安全的.
     */
    private static void test1(){
        Object obj = null;
        // 如果对象为null,则输出0
        System.out.println(Objects.hashCode(obj));
        //如果对象为null,则输出null
        System.out.println(Objects.toString(obj));
        // 要求obj参数不能为null,如果为null,则抛异常
        System.out.println(Objects.requireNonNull(obj,"该值为null"));
    }
}
