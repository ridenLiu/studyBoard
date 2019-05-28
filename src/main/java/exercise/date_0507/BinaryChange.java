package exercise.date_0507;

import org.junit.jupiter.api.Test;

public class BinaryChange {


    @Test
    public void test() {
        String res = getBinary(-7);
        System.out.println(res);

//        int a = -20;
//        a = a<<3;
//        System.out.println("结果:"+a);


    }

    public String getBinary2(int num){



        return "";
    }


    // 将十进制转换为二进制
    public String getBinary(int num) {
        if (num == 1 || num == 0) {
            return num + "";
        }
        String res = "";
        int count = 0;
        int twoNum = 2;
        while (true) {
            count++;
            if (num <= twoNum) {
                if(num==twoNum){
                    count++;
                }
                break;
            }
            twoNum = twoNum * 2;
        }
        System.out.println("count: " + count);
        if (twoNum == num) {
            res = "1";
            num = 0;
            count--;
        }
        for (int i = 0; i < count; i++) {
            twoNum = (int) Math.pow(2, count - i - 1);
            if (num < twoNum) {
                res = res + "0";
            } else {
                num = num - twoNum;
                res = res + "1";
            }
        }
        return res;
    }


}
