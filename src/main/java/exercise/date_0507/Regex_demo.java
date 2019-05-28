package exercise.date_0507;

import org.junit.jupiter.api.Test;

public class Regex_demo {
    // 首位是字母,后面可以是字母,数字下滑线 6-18
    @Test
    public void test1(){
        String regex = "^[a-zA-z]\\w{5,17}$";
        String str = "a1111111";
        boolean isRight = str.matches(regex);
        System.out.println("result:"+isRight);
    }
}
