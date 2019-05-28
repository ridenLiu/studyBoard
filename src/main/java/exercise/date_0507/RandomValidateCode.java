package exercise.date_0507;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomValidateCode {
    // 能随机生成一个6位验证码,包括数字大写字母小写字母

    public String getValudateCode(){
        Random rand = new Random();
        int typeNumber;
        StringBuilder resultStr = new StringBuilder(); // 结果
        char letterCaseType; // 字母大小写类型
        for (int i = 0; i < 6; i++) {
        typeNumber = rand.nextInt(3);
        if(typeNumber==0){
            resultStr.append(rand.nextInt(10));
        }else{
            letterCaseType = typeNumber==1?'a':'A';
            int num = rand.nextInt(26)+(int)letterCaseType;
            resultStr.append((char)num);
        }
        }

        return resultStr.toString();
    }

    @Test
    public void testAnswer(){
        for (int i = 0; i < 10; i++) {
        String str = getValudateCode();
        System.out.println(str);
        }

    }

    @Test
    public void test1(){
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int res = rand.nextInt(26)+(int)'a';
            System.out.println(res);
            char ch = (char)res;
            //System.out.println(ch);
            if(res == (int)'z'){
                System.out.println("ok fro z");
            }
            if(res == (int)'a'){
                System.out.println("ok for a");
            }



        }
    }
}

