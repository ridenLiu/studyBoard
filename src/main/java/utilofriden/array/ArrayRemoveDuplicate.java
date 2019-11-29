package utilofriden.array;

import java.util.Arrays;

public class ArrayRemoveDuplicate {

    /**
     * 去除数组中重复的数据,前提是该数组中的元素必须实现了Comparable接口
     *
     * @param array 需要去除重复元素的数组
     * @return 已经排序且没有重复元素的数组
     */
    public static Object[] sortAndRemoveDuplication(Object[] array) {
        // 排序
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].equals(array[i + 1])) {
                array = removeIndexElement(array,i);
            }
        }
        return array;
    }

    /**
     * 去除数组中重复的元素
     * @param array
     * @return
     */
    public static Object[] removeDuplicationType01(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if(array[i].equals(array[j+1])){
                    array = ArrayRemoveDuplicate.removeIndexElement(array,i);
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 去除指定下标的数组并井数据缩容
     * @param array 数组
     * @param index 需要删除的元素下表
     * @return 缩容后的数组
     */
    public static Object[] removeIndexElement(Object[]array,int index){
        if (index < array.length / 2) {
            for (int j = index - 1; j >= 0; j--) {
                array[j + 1] = array[j];
            }
            array = Arrays.copyOfRange(array, 1, array.length);
        } else {
            for (int j = index; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array = Arrays.copyOfRange(array, 0, array.length - 1);
        }
        return array;
    }
}
