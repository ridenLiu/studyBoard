package exercise.date_0507;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NPeople {
    /**
     * n人围成一个圈,从第一个人开始报数,数到第m个人出列,然后从出列的下一人个开始报数,数到第m个又出列,
     * 如此反复直到所有人都出列,n个人的编号为1,2,....n,打印出全部出列的顺序
     */

    @Test
    public void test() {
        getResult(3, 4);
    }


    public void getResult(int n, int m) {
        int[] originalArr = new int[n];
        int[] resultArr = new int[n];
        // 初始化数组
        for (int i = 0; i < n; i++) {
            originalArr[i] = i + 1;
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 1 == m) {
                    // 将出列的数放进结果数组
                    resultArr[i] = originalArr[num];
                    // 将出列的数从原来的数组去除
                    originalArr[num] = n + 1;
                    Arrays.sort(originalArr);
                    originalArr = Arrays.copyOf(originalArr, originalArr.length - 1);
                    num--;
                }
                num++;
                if (num >= originalArr.length) {
                    num = 0;
                }
            }
        }
        System.out.println("结果:" + Arrays.toString(resultArr));
    }

    @Test
    public void test2() {
        int n = 6;
        int[] orginalArr = new int[n];
        // 初始化数组
        for (int i = 0; i < n; i++) {
            orginalArr[i] = i + 1;
        }
        System.out.println(Arrays.toString(orginalArr));

        orginalArr[3] = orginalArr.length + 1;
        Arrays.sort(orginalArr);
        int[] newArr = Arrays.copyOf(orginalArr, orginalArr.length - 1);
        System.out.println(Arrays.toString(newArr));

    }
}
