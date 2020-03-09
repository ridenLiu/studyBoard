package API.collection.Outdated;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CollectionTest {

    public static void main(String[] args) {
        // todo main
    }

    /**
     * Collection中的一些方法
     */
    @Test
    public void test1() {
        Collection c = new ArrayList();
        //添加
        c.add("集中精力");
        c.add(47);
        c.remove(47);
        int size = c.size();
        boolean b = c.contains("集中精力");
        Collection c2 = new HashSet();
        c2.add("集中精力");
        c2.add("testStr");
        // c.removeAll(c2);
    }

    /**
     * 使用foreach遍历集合
     */
    @Test
    public void test2() {
        Collection books = new HashSet();
        books.add("北京富婆电话号码手册");
        books.add("摸鱼一百招");
        books.add("吃论");
        books.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("遍历元素: " + o);
            }
        });

        books.forEach(o -> System.out.println("lambda遍历: " + o));
    }

    Collection book = new ArrayList();

    {
        book.add("斯通纳");
        book.add("追风筝的人");
        book.add("人类简史");
        book.add("疯狂java讲义");
    }


    /**
     * 使用iterator遍历集合
     */
    @Test
    public void test3() {
        Iterator iterator = book.iterator();
        while (iterator.hasNext()) {
            String res = iterator.next().toString();
//            book.remove("斯通纳");
//            book.add("斯通纳");
            if ("人类简史".equals(res)) {
                iterator.remove(); // 使用iterator遍历集合时,不能使用其他方式修改集合元素,比如上面注释的代码
            }
            System.out.println("res: " + res);
        }
        System.out.println("book: " + book);
    }

    /**
     * 使用lambda表达式遍历iterator
     */
    @Test
    public void test4() {
        Iterator iterator = book.iterator();
        iterator.forEachRemaining(obj -> System.out.println("lambda遍历iterator: " + obj));
    }

    /**
     * 使用foreach遍历集合
     */
    @Test
    public void test5() {
        for (Object object : book) {// 使用foreach遍历时,和iterator一样不能改变集合中的元素
            System.out.println("foreach遍历: " + object.toString());
        }
    }

    /**
     * 使用Predicate操作集合
     */
    @Test
    public void test6() {
        book.removeIf(new Predicate() {
            @Override
            public boolean test(Object o) {
                return o.toString().length() > 4;
            }
        });
        System.out.println("book: " + book);
    }


    /**
     * 使用Stream
     * 1. Stream提供了大量的方法进行聚集操作,这些方法既可以时'中间的(intermediate)'也可以是'末端的(terminal)'
     * 中间方法: 中中间操作运行刘保持打开状态,并允许直接调用后续方法
     * 末端方法: 末端方法是对流的最终操作.当对某个Stream执行末端方法后,流会被'消耗'并不再可用',下面的max()等方法都是如此
     */
    @Test
    public void test7() {// todo
        IntStream.Builder builder = IntStream.builder();
        builder.add(1);
        builder.add(3);
        builder.add(-1);
        builder.add(10);
        IntStream is = builder.build();
        // 下面调用的代码每次只能调用一个
//        System.out.println("is中最大元素: " + is.max().getAsInt());
//        System.out.println("is中最小元素: " + is.min().getAsInt());
//        System.out.println("is中元素总和: " + is.sum());
//        System.out.println("is中最大总数: " + is.count());
        System.out.println("is的平均值 : " + is.average());
//        System.out.println("is所有元素的平方都大于20: " + is.allMatch(ele -> ele * ele > 20));
//        System.out.println("is包含的元素中是否有元素的平方大于20: " + is.anyMatch(ele -> ele * ele > 20));

    }

    /**
     * 使用流操作集合元素
     * Collection接口提供了stream()默认方法,该方法可以返回集合对应的流
     */
    @Test
    public void test8() {
        System.out.println(book.stream().filter(ele -> ele.toString().length() < 4).count());
    }

    /**
     * Set集合
     * 一. HashSet
     * 1. 不能保保证元素的排序顺序
     * 2. HashSet不是同步的
     * 3. 集合的元素值可以为null
     * 4. HashSet判断两个对象相等的条件是: equals()方法返回true同时HashSet()方法返回值相同
     * 二. TreeSet
     * TreeSet采用红黑树的数据结构来储存集合元素.所以得对元素进行排序
     * TheeSet并不是根据元素的插入顺序排序的,默认时使用自然排序
     * 1. 自然排序:
     * TreeSet调用集合元素的compareTo(Object obj)方法来比较元素之间的大小关系,再根据大小进行排序.
     * java提供了Comparable接口,该接口定义了int obj1.compareTo(obj2): 方法如果返回结果为0表示大小相同,结果为正整数则obj1大,结果为负整数obj2大.
     * TreeSet集合中的对象必须实现了Comparable接口,否者使用会报错,(添加第一个时倒不会报错,因为不用比较)
     * 由于需要进行比较,则TreeSet中的元素必须都是同一个类的实例.
     * 向TreeSet添加元素时,如果通过compareTo方法返回的结果为0,则无法添加元素,因为TreeSet集合判断两个对象是否先等的唯一标准时compareTo方法.
     * 如果向TreeSet中放入可变元素,如果元素改变会导致改变的元素无法删除,而且与修改后相同的(compareTo结果为0)元素也无法修改.
     */
    @Test
    public void test9() {
        TreeSet ts = new TreeSet();
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(-1);
        Integer a3 = new Integer(5);
        Integer a4 = new Integer(9);
        ts.add(a1);
        ts.add(a2);
        ts.add(a3);
        ts.add(a4);
        System.out.println(ts); // TreeSet会自动排序
        System.out.println("first: " + ts.first()); // 输出集合中第一个元素
        System.out.println("last: " + ts.last());
        int lower = (int) ts.lower(4); // 返回小于4的最大元素
        int higher = (int) ts.higher(5); // 返回大于5的最小元素
        System.out.println("lower: " + lower + " higher: " + higher);

        TreeSet<Integer> ts2 = new TreeSet<>((o1, o2) -> // 可以自定义排序
                Integer.compare(0, o1 - o2)
        );
        ts2.add(4);
        ts2.add(-1);
        ts2.add(3);
        ts2.add(9);
        System.out.println(ts2);
    }

    @Test
    public void test10() {
        // 一. 创建一个EnumSet集合,集合元素是Player枚举类的全部枚举值
        EnumSet<Player> players = EnumSet.allOf(Player.class);
        System.out.println(players);
        // 二. 常见一个EnumSet空集合,指定其集合元素是Player类的枚举
        EnumSet enum1 = EnumSet.noneOf(Player.class);
        enum1.add(Player.DROGBA);
        enum1.add(Player.BOLT);
        System.out.println(enum1);
        // 三.指定枚举值创建EnumSet集合
        EnumSet es1 = EnumSet.of(Player.BOLT, Player.MBAPPE);
        System.out.println("es1: " + es1);
        // 四.获取集合的补集
        EnumSet es2 = EnumSet.complementOf(es1);
        System.out.println("es2: " + es2);
        // 五.可以从其他Collection对象中复制枚举值,如果被复制的集合对象众多元素只能包含同一个类的枚举值,否则会报转型错误
        Collection c = new HashSet();
        c.add(Player.BOLT);
        c.add(Player.MBAPPE);
        EnumSet es3 = EnumSet.copyOf(c);
        System.out.println("es3: " + es3);
    }

    /**
     * List集合
     * List集合代表一个元素有序,可重复的集合,集合中每个元素都有对应的顺序索引.
     */
    @Test
    public void testList() {
        List books = new ArrayList();
        books.add(new String("西部世界"));
        books.add(new String("java we can"));
        books.add(new String("星球大战"));
        System.out.println("books: " + books);
        books.add(1, new String("ass you can"));
        System.out.println("after add: " + books);
        /*
        remove方法会调用对象的equals方法寻找对象
         */
        books.remove(1);
        System.out.println("after remove: " + books);
        books.set(2, "星球大战2");
        System.out.println("after set: " + books);
        System.out.println("subList: " + books.subList(0, 2));
    }

    @Test
    public void testList2() {
        List books = new ArrayList();
        books.add(new String("西部世界1"));
        books.add(new String("java we can"));
        books.add(new String("星球大战"));
        // 使用目标类型为Comparable的Lambda表达式对List集合排序
        books.sort((a1, a2) -> ((String) a1).length() - ((String) a2).length());
        System.out.println("after sort: " + books);
        // 使用UnaryOperator的Lambda表达式替换集合中的所有元素
        books.replaceAll(ele -> ele.toString().length());
        System.out.println("after replaceAll: " + books);
    }

    /**
     * 使用ListIterator遍历list集合
     */
    @Test
    public void testList3() {
        List books = new ArrayList();
        books.add(new String("西部世界1"));
        books.add(new String("java we can"));
        books.add(new String("星球大战"));
        ListIterator lit = books.listIterator();
        // 使用lit遍历
        while (lit.hasNext()) {
            System.out.println("lit遍历:" + lit.next());
        }
        //  使用lit反向遍历
        while (lit.hasPrevious()) {
            System.out.println("lit遍历2: " + lit.previous());
        }
    }

    /**
     * 使用Arrays.asList()将数组转换成长度固定的集合
     * 试图修改该集合都会产生UnsupportedOperationException
     */
    @Test
    public void testList4() {
        String[] strs = new String[]{"雷登,本泽奈", "德罗巴", "姆巴佩", "博尔特"};
        List fixedList = Arrays.asList(strs);
        System.out.println(fixedList);
        fixedList.sort(((o1, o2) -> o1.toString().length() - o2.toString().length()));
        System.out.println("after sort: " + fixedList);
    }

    /**
     * Queue集合
     */
    @Test
    public void QueueTest() {
        Queue q1 = new PriorityQueue(); // PriorityQueue会自动排序
        q1.add(2);
        q1.add(1);
        q1.add(9);
        System.out.println("q1: " + q1);
    }

    /**
     * Deque接口
     * Deque接口时Queue的子接口,他代表一个双端队列,Deque接口里定义了一些双端队列的方法,允许从双端来操作队列的元素
     */
    @Test
    public void ArrayDequeTest() {
        // ArrayDeque类时Deque接口的一个实现类
        Deque deque = new ArrayDeque();
        deque.add("first");
        deque.add("second");
        deque.add("third");
        System.out.println("deque: " + deque);
        System.out.println("peek: " + deque.peek());
        System.out.println("getFirst: " + deque.getFirst());
        /*
        使用Deque模拟栈
        当程序中要使用栈的数据结构式推荐使用ArrayDeque类,而不是Stack因为Stack式古老的集合,性能较差
         */
        Deque stack = new ArrayDeque();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println("stack: " + stack); // 先进后出
        System.out.println("stack peek: " + stack.peek());
        stack.offer("offer1"); // 依次将对象放入集合中
        stack.offer("offer2");
        stack.offer("offer3");
        System.out.println("after offer stack: " + stack);
    }

    /**
     * LinkedList实现类
     * LinkedList类式List接口的实现类,而且LinkedList还实现了Deque接口,可以被当成双向队列类使用
     */
    @Test
    public void LinkedListTest() {
        LinkedList list = new LinkedList();
        list.offer("offer1");
        list.offer("offer2");
        list.offer("offer3");
        System.out.println("list: " + list);
        list.push("push1"); // 将元素放入栈顶
        System.out.println("after push: " + list);
        list.offerFirst("offerFirst1");
        System.out.println("offerFirst: "+list);
        // peek操作对不会删除元素
        System.out.println("peekFirst: "+list.peekFirst());
        System.out.println("peekLast: "+list.peekLast());
        System.out.println("pop: "+list.pop());
        System.out.println("poll: "+list.poll());
        System.out.println("after pop&poll: "+list);
    }
    /**
     * ArrayList和LinkedList的性能分析
     * 1. 由于ArrayList是使用数组保存数据的,所以它的随机访问性能好.(随机访问,不通过遍历的元素查找)
     * 2. 而由于LinkedList是使用链表保存数据的,它在执行插入,删除操作时有较好的性能.
     */

}


enum Player {
    BOLT, DROGBA, MBAPPE
}
