package basic;

public  class Demo_abstract {
    /**
     * 抽象类
     * 1. 抽象类必须使用abstract符来修饰,抽象方法也需要使用abstract修饰,抽象方法不能由方法体
     * 2. 抽象类不能被实例化.其构造器不能用于创建对象,主要是被其字类调用.
     * 3. 含有抽象方法的类(包括直接定义,继承但未实现),只能被定义未抽象类
     * 总结: 有得有失,得抽线能力,失创建实例
     * 4. abstract方法强制字类重写,所以abstract和final关键字不能同时使用
     * 5. abstract不能和static同时使用,static修饰则没有实例,ab修饰则没有方法体.
     * 6. abstract只有让字类重写才有意义,所以不能和private同时使用
     * 7. abstract不能修饰变量,构造器
     *
     */

    public static void main(String[] args) {
       Ab1 sub = new Sub();
       sub.m2();
    }


}

abstract class Ab1{

    Ab1(){
        System.out.println("ab1's construct");
    }
    abstract void abM1();
    void m2(){};
}

class Sub extends Ab1{

    @Override
    void abM1() {

    }
}
