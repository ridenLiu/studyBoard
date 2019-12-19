package API.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 与用户进行交互
 */
public class Scanner_1 {
    public static void main(String[] args) {
//        scannerTest1();
        scannerFileTest();
    }

    /**
     * 一 . main方法: public static void main(String[]args){}
     * 1 public 修饰符:java类让JVM调用,使用public使其暴露
     * 2 static 修饰符: 不必创建类的对象,直接通过类调用方法
     * 3 void 返回值: 方法的返回值交给JVM没有意义
     * 4 String[]args 参数: 可以在java命令中添加值,java classFullName str1 str2 ...
     * 其中str1和str2 会被作为args的值
     */
    public static void main2(String[] args) {
        System.out.println("length: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    /**
     * 使用Scanner获取键盘输入
     * 1. Scanner是一个基于正则表达式的文本扫描器,它有多个构造器,不同构造器可以从文件,输入流,字符串作为数据源,
     * 用于从文件,输入流,字符串中解析数据.
     * 2. Scanner主要有两个方法扫描输入
     * 2.1 hasNextXxx() : 是否有下一个输入项,Xxx是基本类型,判断字符串则直接使用hasNext().
     * 2.2 nextXxx(): 获取下一个输入项,Xxx和上方法一致
     */
    private static void scannerTest1() {
        // System.in代表标准输入,就是键盘输入
        Scanner sc = new Scanner(System.in);

//        sc.useDelimiter("\n");
        while (sc.hasNext()) {
            String inputStr = sc.next();
            System.out.println("输入值: " + inputStr);
            if ("break".equals(inputStr)) {
                break;
            }
        }
    }

    private static void scannerFileTest() {
        StringBuilder str = new StringBuilder();
        try {
            Scanner sc = new Scanner(new File("D:\\test_board\\test1\\src\\main\\java\\pac1\\Test2.java"));
            while (sc.hasNextLine()) {
                str.append(sc.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }

}
