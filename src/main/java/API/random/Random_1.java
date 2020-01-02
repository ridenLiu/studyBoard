package API.random;

import java.util.Arrays;
import java.util.Random;

public class Random_1 {
    public static void main(String[] args) {
        Random random = new Random();
        // 随机boolean值
        System.out.println("random.nextBoolean(): "+random.nextBoolean());
        byte[]buffer = new byte[16];
        random.nextBytes(buffer); // 随机数组
        System.out.println(Arrays.toString(buffer));



    }
}
