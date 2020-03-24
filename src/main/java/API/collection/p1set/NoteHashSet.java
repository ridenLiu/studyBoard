package API.collection.p1set;

import java.util.Collections;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;


public class NoteHashSet {


    public static void main(String[] args) {
        HashSet set1 = new HashSet();
        set1.add("riden");
        set1.add("riden");
        System.out.println(set1);
    }

    /**
     * 各set集合性能分析
     * 1. HashSet的性能总要好于TreeSet,这是由于TreeSet要维护一个红黑树算法来维护顺序
     * 2. LinkedHashSet插入,删除比HashSet要慢,但是它的遍历性能更好
     * 3. EnumSet时性能最好的,但是它只能保存同类枚举值
     * 4. HashSet,TreeSet,EnumSet都不是线程安全的.如果需要线程安全通常可以使用
     * Collections工具类的synchronizedSortedSet,来包装set集合
     */
    static void test1() {
        TreeSet set = new TreeSet();
        SortedSet s = Collections.synchronizedSortedSet(set);
    }


}
