package exercise.date_0507;

import org.junit.jupiter.api.Test;

public class Plalindrome {

    // 判断一个字符串是否是回文
    public boolean isPlalindrome(String str) {
        int round = str.length();
        for (int i = 0; i < round; i++) {
            if (str.charAt(i) != str.charAt(round - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testResult() {
        String str = "1112111";
        System.out.println(isPlalindrome(str));
    }


}
