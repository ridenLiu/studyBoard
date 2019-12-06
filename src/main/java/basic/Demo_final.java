package basic;

/**
 * final修饰变量时,变量一旦获取初始值就不可被改变
 *
 * 1. final修饰的成员变量必须由程序显示的指定其初始值
 */
public class Demo_final {
    char c;
    public static void main(String[] args) {
        Demo_final demo_final = new Demo_final();
        System.out.println(">"+demo_final.c+"<");
    }
}
