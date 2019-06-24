package API.BoxType;

public class AutoOfInteger {

    public static void main(String[] args) {
        // int和integer之间的自动转换
        int a = 0;
        Integer b = new Integer(1000);

        b = Integer.valueOf(a); // 自动装箱调用方法
        a = b.intValue(); // 自动拆箱调用方法


    }

}
