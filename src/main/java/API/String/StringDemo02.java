package API.String;


import org.junit.Test;

import java.nio.charset.Charset;

public class StringDemo02 {

    @Test
    public void contructorString(){
        // 1. 通过使用平台的默认字符集解码指定的字节数组来构造新的 String
        String str1 = new String(chars);
        System.out.println(str1);
        // 2. 通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。
        String str2 = new String(chars,1,4);

    }

    private static char[] chars = {'a','b','c','d','e'};
    static String str = "ariden123";

    @Test
    public void methodString(){
        // 1. 返回 char指定索引处的值。
        char res = str.charAt(1);
        System.out.println(res);

        // 2. 返回对应字符的Unicode代码点
        int res2 = str.codePointAt(1);
        System.out.println(res2);

        // 3. 返回有多少个字符?
        int res3 = str.codePointCount(0,2);
        System.out.println("res3:"+res3);
        // 4. 转换数组
        char [] dst = new char[str.length()];
        str.getChars(0,str.length(),dst,0);
        System.out.println(dst);

    }

}
