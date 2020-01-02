package API.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_1 {
    /**
     * 一. String类关于正则表达式的常用方法
     * boolean matches(String regex): 判断字符换时候包含指定的正则表达式
     * String replaceAll(String regex,String replacement)
     * String replaceFirst(String regex,String replacement)
     * String[]split(String regex);
     * 二. Pattern对象是正则表达式编译后在内存中的表现形式.
     * 正则表达式需先被编译为Pattern对象,然后再利用pattern对象创建对应的Matcher对象.
     */
    @Test
    public void test1() {
        Pattern p = Pattern.compile("a*b");
        // 使用Pattern对象创建Matcher对象
        Matcher m = p.matcher("aaab");
        boolean b = m.matches();
        System.out.println("res: " + b);
        // 如果该正则表达式仅执行一次,则可以使用Pattern的静态方法matches
        boolean b2 = Pattern.matches("a*b", "aaaab");
        System.out.println("res2: " + b2);
    }

    /**
     * 二: Matcher
     * 1. find(): 返回目标字符串是否包含与Pattern匹配的字符串
     * 2. group(): 返回上一次与Pattern匹配的字符串
     */
    @Test
    public void test2() {
        String str = "this is my phoneNumber: 13707938151.if you want buy a super car,you can call me 15977771234,or my assistant: 13712345678";
        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        // 使用find和group可以找到匹配的字符串
        while (m.find()) {
            System.out.println("res: " + m.group());
        }
    }

    /**
     * 3. start(): 返回上一次与Pattern匹配的字符串在目标字符串的开始位置
     * 4. end(): 返回上一次与Pattern匹配的字符串在目标字符串中的位置+1
     */
    @Test
    public void test3() {
        String str = "all   by  myself";
        Matcher m = Pattern.compile("\\s+").matcher(str);
        while (m.find()) {
            System.out.println(m.group() + "起始位置: " + m.start() + " 结束位置: " + m.end());
        }
    }

    /**
     * 5. lookingAt(): 返回目标字符串前面部分与Pattern是否匹配.
     * 6. matches(): 返回整个目标字符串与Pattern是否匹配
     * 区别:
     * matches()方法需整个字符串和Pattern匹配才返回true
     * lookingAt(): 字符串一Pattern开头就会返回true
     * <p>
     * 7. reset(): 将现有的Matcher对象应用与一个新的字符序列
     */
    @Test
    public void test4() {
        String[] mails = {
                "riden@163.com",
                "benzene@gmail.com",
                "hongkong@riden.org",
                "ddba@abc.xx"
        };
        String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern mailPattern = Pattern.compile(mailRegEx);
        Matcher matcher = null;
        for (String mail : mails) {
            if (matcher == null) {
                matcher = mailPattern.matcher(mail);
            } else {
                matcher.reset(mail);
            }
            String res = mail + (matcher.matches() ? " 是" : " 不是") + "有效邮件地址";
            System.out.println(res);
        }
    }

    @Test
    public void test5() {
        String[] mgs = {
                "when i was young",
                "i listen to the radio",
                "waiting for my favorite song."
        };
        Pattern p = Pattern.compile("t\\w*");
        Matcher m = null;
        for (String str : mgs) {
            if (m == null) {
                m = p.matcher(str);
            } else {
                m.reset(str);
            }
            System.out.println(m.replaceAll("\\$test\\$"));
        }
    }


}
