package basic;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * java8.lambda支持将代码作为方法参数(以前是匿名内部类)
 * 1. 构成
 * 1.1 形参列表.形参列表允许省略形参类型,如果形参类表中只有一个参数,连形参列表的圆括号也可以省略
 * 1.2 箭头(->),英文减号和大于号
 * 1.3 代码块,由花括号包围,如果只有一条语句,可以省略画括号.如果只有一条return语句,可以省略return关键字.
 * 2. lambda表达式与函数式接口
 * 2.1 函数式接口是只包含一个抽象方法的接口.函数式接口可以包含多个默认方法,类方法,但只能声明一个抽象方法.
 * 2.2 java8专门提供了@FunctionalInterface注解.
 * 3. lambda表达式的限制
 * 3.1 lambda表达式的目标类型必须是明确的函数式接口
 * 3.2 lambda表达式只能为函数式接口创建对象,因为lambda表达式只能实现一个方法.
 */
public class Demo_lambda {

    /**
     * 使用lambda实现命令模式
     */
    void commandTest2() {
        CommandCla command = new CommandCla();
        String[] strs = new String[]{"a", "b", "c"};
        String res = (String) command.processImp(strs, obj -> {
            String[] strs1 = (String[]) obj;
            return Arrays.toString(strs1);
        });
    }

    /**
     * 使用匿名内部类实现命令模式
     */
    void commandTest1() {
        CommandCla command = new CommandCla();
        String[] strs = new String[]{"a", "b", "c"};
        String res = (String) command.processImp(strs, new CommandInterface() {
            @Override
            public Object process(Object obj) {
                String[] strs = (String[]) obj;
                return Arrays.toString(strs);
            }
        });
        System.out.println(res);
    }
}

interface CommandInterface {
    Object process(Object obj);
}

class CommandCla {
    Object processImp(Object par, CommandInterface commandInterface) {
        return commandInterface.process(par);
    }
}

//==================方法引用和构造器引用================

/**
 * 4. lambda表达式的代码块只有一条代码,程序就可以省略表达式中的花括号.不仅如此,如果lambda表达式的代码块
 * 只有一条代码,在代码中还可以使用方法引用和构造器应用.
 */
class LambdaMethod {


    public static void main(String[] args) {

    }

    /**
     * 1. 引用类方法
     */
    static void test1() {
        String str = "10";
        // 1. 使用Lambda表达式创建对象
        Converter converter1 = (form) -> {
            return Integer.parseInt(form);
        };
        // 测试1
        Integer res1 = converter1.converter(str);
        System.out.println("res1: " + res1);

        // 2. 使用类引用
        Converter converter2 = Integer::parseInt;
        Integer res2 = converter2.converter(str);
        System.out.println("res2 :" + res2);
    }

    /**
     * 引用特定对象实例方法
     */

    static void test2() {
        Converter converter1 = from -> {
            return "testStr".indexOf(from);
        };
        Converter converter2 = "testStr"::indexOf;
        int res1 = converter1.converter("s");
        int res2 = converter2.converter("s");
        System.out.println("res1 :" + res1 + " res2: " + res2);
    }

    /**
     * 引用某类对象的实例方法
     */
    static void test3() {
        MyTest1 test1 = (a, b, c) -> {
            return a.substring(b, c);
        };
        // 函数时接口方法的第一个参数作为调用者
        MyTest1 test2 = String::substring;
    }

    /**
     * 引用构造器
     */
    static void test4() {
        YourTest1 test1 = (title -> {
            return new JFrame(title);
        });
        YourTest1 test2 = JFrame::new;
    }


}

@FunctionalInterface
interface YourTest1 {
    JFrame win(String title);
}

@FunctionalInterface
interface MyTest1 {
    String test(String s, int b, int c);
}

@FunctionalInterface
interface Converter {
    Integer converter(String from);
}


//=====================lambda 与函数式接口=================

/**
 * 3. lambda表达式的限制
 * 3.1 lambda表达式的目标类型必须是明确的函数式接口
 * 3.2 lambda表达式只能为函数式接口创建对象,因为lambda表达式只能实现一个方法.
 */
class LambdaWithFunctionalInterface {
    void test1() {
        Object obj = (Runnable) () -> {
            System.out.println("running=====");
        };
    }
}

//=====================lambda exercise=====================


class LambdaTest {
    void eat(Eatable eatable) {
        System.out.println(eatable);
        eatable.taste();
    }

    void fly(String flyType, Flyable flyable) {
        flyable.fly(flyType);
    }

    int add(int a, int b, Addable addable) {
        return addable.add(a, b);
    }

    public static void main_(String[] args) {
        LambdaTest lam = new LambdaTest();
        lam.eat(() -> System.out.println("我就尝一口"));

        lam.fly("eagle", flyType -> System.out.println("fly like a " + flyType));

        int res = lam.add(1, 2, Integer::sum);// 单挑语句可以省略return关键字
    }

}

@FunctionalInterface
interface Eatable {
    void taste();
}

interface Flyable {
    void fly(String type);
}

interface Addable {
    int add(int a, int b);
}

