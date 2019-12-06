package designMode;

/**
 * 命令模式,及需完成一个行为,但这个行为的具体实现无法确定,必须等到执行该方法时才可以确定.
 */
public class CommandMode {

    /**
     * 命令模式,及可以在方法中传入代码(配合匿名内部类)
     */
    static void CommendModeDemo() {
        Cla1 obj = new Cla1();
        Object[] parameters = new Object[10];
        Object res = obj.process(parameters, new Ite1() {
            @Override
            public Object md1(Object[] objects) {
                for (int i = 0; i < objects.length; i++) {
                    if (objects[i] != null) {
                        System.out.println(objects[i].toString());
                    }
                }
                return null;
            }
        });
    }

}


class Cla1 {
    Object process(Object[] objects, Ite1 ite1) {
        return ite1.md1(objects);
    }
}

interface Ite1 {
    Object md1(Object[] objects);
}
