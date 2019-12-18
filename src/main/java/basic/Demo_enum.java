package basic;

/**
 * 枚举类
 * 特点:
 * 1. 枚举类可以实现一个或多个接口,使用enum的枚举类默认继承了java.lang.Enum,而不是默认继承java.lang.Object,
 * 因此枚举类不能显示的继承其他父类,其中java.lang.Enum实现了java.lang.Serializable和java.lang.Comparable
 * 2. 使用enum定义,非抽象的枚举会默认使用final修饰,所以枚举类不能派生字类
 * 3. 枚举类的构造器默认是private修饰的,也只能是private修饰
 * 4. 枚举类的实例必须在枚举类的第一行显示列出,系统自动添加public static final修饰
 */
public class Demo_enum {
    public static void main(String[] args) {
        // 枚举类的实例只能是枚举值,而不能通过new创建的枚举类对象
        SeasonEnum seasonEnum = Enum.valueOf(SeasonEnum.class, "SPRING");
        double res1 = Operation.PLUS.eval(3,2);
        System.out.println("res1: "+res1);



    }
}

enum Operation {
    PLUS {
        @Override
        public double eval(double a, double b) {
            return a + b;
        }
    }, MINUS {
        @Override
        public double eval(double a, double b) {
            return a - b;
        }
    }, TIMES {
        @Override
        public double eval(double a, double b) {
            return a * b;
        }
    }, DIVIDE {
        @Override
        public double eval(double a, double b) {
            return a / b;
        }
    };

    public abstract double eval(double a, double b);
}

enum Gender {
    MALE("男"), FEMALE("女");
    private final String name;

    private Gender(String name) {
        this.name = name;
    }
}

enum SeasonEnum {
    // 在第一行列出实例
    SPRING, SUMMER, FALL, WINTER;
    public String name;
}
