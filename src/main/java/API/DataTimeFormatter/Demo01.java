package API.DataTimeFormatter;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Demo01 {
    /**
     * 一些固定的格式标准
     */
    @Test
    public void formatterTest() {
        // 直接使用常量创建DataTimeFormatter格式器
        DateTimeFormatter[] formatters = new DateTimeFormatter[]{
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                // 使用本地化的不同风格来创建DataTimeFormatter
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
//                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG),
                // 根据模式字符串来船舰DataTimeFormatter格式器
                DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"),
        };
        LocalDateTime date = LocalDateTime.now();
        // 使用不同格式对localDateTime进行格式化
        for (int i = 0; i < formatters.length; i++) {
            System.out.println(date.format(formatters[i]));
//            System.out.println(formatters[i].format(date));
        }
    }

    /**
     * 使用DataTimeFormatter解析字符串
     */
    @Test
    public void test2(){
        String str1 = "2019==09==12 12时06分09秒";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        LocalDateTime ldt1 = LocalDateTime.parse(str1,formatter1);
        System.out.println("ldt1: "+ldt1);
    }


}
