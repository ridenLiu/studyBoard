package API.collection.p1set;

import java.util.HashSet;

public class NoteHashSet {


    /**
     * 1. set集合不能放入重复的元素
     *
     * @param args
     */

    public static void main(String[] args) {
        HashSet set1 = new HashSet();
        set1.add("riden");
        set1.add("riden");
        System.out.println(set1);
    }


}
