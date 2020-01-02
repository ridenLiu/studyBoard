package API.object;

public class Object_1 {
    /**
     * 1. boolean equals(Object obj),判断指定对象是否相等,默认逻辑是同一个对象才相等
     * 2. protected void finalize(); 当系统中对象没有强引用时,垃圾回收器在清除对象前会调用该方法.
     * 3. Class<?>getClass(): 返回对象的运行时类
     * 4. int hashCode(): 返回对象的字符串显示.默认时根据对象的内存地址得出结果
     * 5. String toString(): 返回对象的字符串显示,默认是 '运行时类名@十六进制hashCode值'格式字符串.
     */
    public static void main(String[] args) {
        cloneDemo();
    }

    /**
     * 6. clone()方法
     * 步骤:
     *  6.1 自定义类实现Cloneable接口.该接口未标记接口,没有任何方法
     *  6.2 重写clone()方法,使用super.clone();获取克隆对象.
     * 需要注意的是,默认的super.clone只是"shallow clone",它只会复制对象的成员变量值,对于引用类型,
     * 仅复制应用,不会对引用类型的对象也复制一份.
     * 但这种"浅克隆"的效率很高
     */
    private static void cloneDemo() {
        Car car1 = new Car();
        car1.name = "凯帕";
        Car car2 = car1.clone();
        System.out.println(car1 == car2);
    }
}

class Car implements Cloneable {
    String name;
    Object obj1 = new Object();

    public Car() {
        System.out.println("create a new Car");
    }

    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
