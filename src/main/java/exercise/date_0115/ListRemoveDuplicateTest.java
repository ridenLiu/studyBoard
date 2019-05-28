package exercise.date_0115;



import org.junit.jupiter.api.Test;
import utilofriden.array.ArrayRemoveDuplicate;
import java.io.IOException;
import java.util.*;

public class ListRemoveDuplicateTest {

    @Test
    public void test4() throws IOException {
//        byte[]bytes = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjxsaXN0Pg0KIDxkYXRhSW5mbyBpZD0iMCI+DQogIDxVU0VSX0lEPkRzM29xPC9VU0VSX0lEPg0KICA8VVNFUk5BTUU+emhhbmd0YW88L1VTRVJOQU1FPg0KICA8UEFTU1dPUkQ+ODlCOUQyMkJFRjREOTRDRTA3MEYzNUM5RTc4RUExNzI8L1BBU1NXT1JEPg0KICA8SVA+MTAuMTIyLjg5LjEzPC9JUD4NCiAgPElQX0JJTkRJTkc+MDwvSVBfQklORElORz4NCiAgPFNUQVJUX1RJTUUgLz4NCiAgPEVORF9USU1FIC8+DQogIDxQUk9KRUNUX05BTUU+QTLpobnnm67nu4Q8L1BST0pFQ1RfTkFNRT4NCiAgPElTX0xPQ0s+MDwvSVNfTE9DSz4NCiA8L2RhdGFJbmZvPg0KPC9saXN0Pg0KDQo=+DQoNCg==".getBytes();
//        byte[]res = Base64.decode(bytes);
//        String resStr = new String(res);
//        System.out.println("resStr:"+resStr);
    }

    @Test
    public void test3() {

        Integer[] array = new Integer[7];
        array[0] = 0;
        array[1] = 1;
        array[2] = 4;
        array[3] = 5;
        array[4] = 5;
        array[5] = 10;
        array[6] = 10;
        array = (Integer[]) ArrayRemoveDuplicate.sortAndRemoveDuplication(array);
        System.out.println("结果");
        System.out.println(Arrays.toString(array));
    }



    @Test
    public void test_removeDuplicationType01() {
        Integer[] array = new Integer[5];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        array[3] = 5;
        array[4] = 5;

        array = (Integer[]) ArrayRemoveDuplicate.removeDuplicationType01(array);
        System.out.println(Arrays.toString(array));

    }





    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.contains(1));
    }

    // 将两个List<Integer>集合合并,不能有重复元素,而且需要中间的数最大,
    // 两边逐渐减小
    @Test
    public void test1() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(3);
        list1.add(1);
        list1.add(5);
        list1.add(3);
        list1.add(10);

        list2.add(1);
        list2.add(2);
        list2.add(6);
        list2.add(7);
        list2.add(9);

        List<Integer> resultList = new ArrayList<>();
        addElement(resultList, list1);
//        addElement(resultList, list2);
//        System.out.println(resultList);


    }

    private void addElement(List base, List sub) {
        Iterator iterator = sub.iterator();
        Integer element;
        Integer[] elements = new Integer[sub.size()];
        int i = 0;
        // 获取所有元素
        while (iterator.hasNext()) {
            elements[i] = (Integer) iterator.next();
            System.out.println(elements[i]);
            i++;
        }
        // 排序
        for (int j = 0; j < elements.length; j++) {
            for (int k = 0; k < elements.length - j - 1; k++) {
                if (elements[k] > elements[k + 1]) {
                    int t = elements[k];
                    elements[k] = elements[k + 1];
                    elements[k + 1] = t;
                }
            }
            System.out.println(Arrays.toString(elements));
        }
        // 去重
        for (int j = 0; j < elements.length - 1; j++) {
            if (elements[j] == elements[j + 1]) {

            }
        }

    }

}
