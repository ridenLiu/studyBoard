package basic;

/**
 *
 * 封装:
 *  概念: 封装是指将对象的状态信息隐藏在对象内部,不允许外部直接访问,但是提供一些方法让外部对信息进行操控
 *  作用:
 *      1. 隐藏类的实现细节
 *      2. 限制对成员变量的不合理访问
 *  访问控制符:
 *      private: 只有本类中可以访问
 *      default: 同包下的其他类可以访问
 *      protected: 同包下的其他类和其他包下的字类访问
 *      pubic: 可以被所有类访问
 *  包: 作用: 处理类重名问题
 *      使用:
 *           package packageName; 在java源文件中的第一个非注释行下使用
 *           import关键字(package语句之后,类定义之前):
 *              import packageName; 导入指定包下的所有类.(使用时省略报名)
 *              import static packageName.className.fieldName|methodName.(省略报名和类名)
 *              import package.*; 该语句中的(*)只代表类不代表包.
 *              导入指定类下的静态成员变量或方法 例: import java.lang.System.out;
 *      常用包:
 *      java.lang: java语言的核心类,如String,Math,System,Thread等,使用这个包下的类无需使用import导入
 *      java.util: 包含大量的工具类/接口/集合框架,如Arrays,list,set
 *      java.net: java网络编程相关
 *      java.io: java输入和输出
 *      java.text: 格式化相关
 *      java.sql: JDBC相关
 *      java.awt: 抽象窗口工具类,用于构建用户图形(GUI)程序
 *      java.awt: 构建与平台无关的GUI程序
 */

public class Demo_encapsulation {

}
