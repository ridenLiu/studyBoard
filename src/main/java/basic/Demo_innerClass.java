package basic;

/**
 * 内部类:
 * 定义: 定义在其他类内部的类称为内部类
 * 作用:
 * 1. 提供更好的封装,比如HumanLeg就因该封装到Human中,其他类不应该能访问humanLeg
 * 2. 内部类成员可以直接访问外部类的私有数据,因为内部来被当作外部类成员,同一个类的成员可以相互访问.
 * 外部类不能访问内部类的实现细节,例如内部类的成员变量
 * 3.匿名内部类使用与创建仅需使用一次的类.比如命令模式中,使用匿名内部类就很方便.
 * 特点:
 * 1. 内部类比外部类多使可以多使用三个修饰符:private,protected,static,外部类不可使用这三个修饰符
 * 2. 非静态内部类不能拥有静态成员
 * 分类:
 * 1. 非静态内部类
 * 2. 静态内部类
 * 3. 局部内部类
 * 4. 匿名内部类
 */
public class Demo_innerClass {
    public static void main(String[] args) {
        // 在外部创建静态内部类对象的方式
        OutterClass2.StaticInnerClass s = new OutterClass2.StaticInnerClass();
        OutterClass2.StaticInnerClass s2;
        s2 = new OutterClass2.StaticInnerClass();
        // 在外部创建非静态内部类的方式,(受访问控制修饰符控制)
        OutterClass1 d = new OutterClass1();
        // 创建非静态内部类对象的创建需要使用外部类实例
        OutterClass1.InnerClass innerClass = d.new InnerClass();
        d.test();
    }

}
interface Inte{}

/**
 * 匿名内部类
 * 1. 适合创建那些只需要使用一次的类,创建匿名内部类的同时会创建一个实例,同时这个类的定义会消失
 * 所以匿名内部类不能重复使用
 * 2. 匿名内部类不能是抽象类,因为定义匿名内部类的同时会立即创建其对象
 * 3. 匿名内部类不能定义构造器.由于匿名内部类没有类名,所以无法定义构造器,但可以定义初始化块
 * 4. java8之前局部类,匿名内部类访问的局部变量必须是final修饰的,java8后这不用(但要遵循effective final,就是没有final但要final方式来)
 * 所以被局部类访问的局部变量初始化后,就不能改动
 *
 */
class OutterClass4{

    public static void main(String[] args) {
        int a = 10;
        a = 2;
        new Inte(){
           void testV(){
               // 这里就会报错,因为a变动了
               //System.out.println(a);
           }
        } ;
    }
}


/**
 * 局部内部类
 * 1. 定义: 如果把一个类放在方法里定义,则这个类就是一个局部内部类,局部内部类仅在方法内有效.
 * 2. 由于局部内部类仅在方法中有效因此局部内部类不能使用访问控制修饰符和static修饰符修饰
 * 3 对于局部成员而言,不管是局部方法还是局部变量他们的上级程序单位都是方法不是类,使用static修饰没有任何意义,
 * 因此所有局部成员都不能使用static修饰,不仅如此因为局部成员的作用域仅限所在方法,所以使用访问控制修饰符没有
 * 意义,所以所有局部成员都不能使用访问控制修饰符
 */
class OutterClass3 {

    void testLocationInnerClass() {
        class LocationInnerClass {
            int a = 1;
            String name = "riden";
        }
        LocationInnerClass lic = new LocationInnerClass();
    }

}

/**
 * 静态内部类
 * 2.1 static关键字的作用是把类成员变成类相关,而不是实例相关.及static对象修饰的成员属于整个类,而不是属于某个对象.
 * 2.2 静态类内部可以包含静态成员,也可以包含非静态成员
 * 2.3 外部类依然不能直接访问金泰内部类的成员
 * 2.4 java允许在接口里定义内部类,接口里定义的内部类默认使用public static修饰,也就是说接口内部类只能是静态内部类
 * (接口中可以定义接口)
 */
class OutterClass2 {

    String s = "hello";
    static String s2 = "hello2";

    static class StaticInnerClass {
        static int age = 1;
        String str = "test";

        void accessOuterProp() {
            //静态内部类无法访问外部类实例
            //System.out.println(s);
            // 可以访问外部静态实例
            System.out.println(s2);
        }
    }
}

/**
 * 非静态内部类: 在类内部方法外声明的类,其作为类的成员可以使用任意的访问控制修饰符
 * 1.1 非静态内部类对象可以直接访问外部类对象,但外部类对象却不能直接(可创建内部类对象访问)访问内部类对象
 * 1.2 非静态内部类不能有静态成员
 */
class OutterClass1 {
    String str = "otterClass's String";

    void test() {
        InnerClass inClass1 = new InnerClass();
        inClass1.testVariableField();
    }

    public class InnerClass {
        String str = "innerClass's String";

        // 相同变量可通着这种方式区分
        void testVariableField() {
            System.out.println("otterCls: " + OutterClass1.this.str);
            System.out.println("innerCls: " + this.str);
        }
    }
}
