package API.time;

import org.junit.Test;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class Time_1 {

    public static void main(String[] args) {
    }

    public void test_time_Year_Month_MonthDay() {
        // 一. 年
        Year year = Year.now();
        System.out.println("当前年: " + year);
        System.out.println("当前年后的3年: " + year.plusYears(3));
        // 二. 年月
        //根据月获取当前年的年月
        YearMonth ym = year.atMonth(10);
        System.out.println("当前年的10月: " + ym);
        // 当前年减5年零3个月
        ym = ym.minusYears(5).minusMonths(3);
        System.out.println("当前年减5年零3个月: " + ym);
        // 三. 月日
        MonthDay md = MonthDay.now();
        System.out.println("当前月日: " + md);
        // 设置为5月22日
        MonthDay md2 = md.with(Month.MAY).withDayOfMonth(22);
        System.out.println("5月22日: " + md2);
    }

    public void test_time_LocalDateTime() {
        // 获取当前日期,时间
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("当前时间: " + ldt);
        // 当前时间后25小时3分钟时间
        LocalDateTime ldt2 = ldt.plusHours(25).plusMinutes(3);
        System.out.println("当前时间后25小时3分钟时间: " + ldt2);
    }

    @Test
    public void test_time_LocalTime() {
        LocalTime localTime = LocalTime.now();
        // 设置为21点50分
        localTime = LocalTime.of(21, 50);
        System.out.println("21点50分: " + localTime);
        // 一天中第66666秒
        localTime = LocalTime.ofSecondOfDay(66666);
        System.out.println("一天中第66666秒: " + localTime);
    }

    @Test
    public void test_time_LocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate: " + localDate);
        // 获取2018年的146天
        localDate = LocalDate.ofYearDay(2018, 146);
        System.out.println("2018年的146天对饮日期: " + localDate);
        // 设置日期为 1999年5月22日
        localDate = LocalDate.of(1999, Month.MAY, 22);
        System.out.println("1999年5月22日: " + localDate);
    }

    public void test_time_Instant() {
        Instant instant = Instant.now(); // 获取当前时间
        System.out.println("instant: " + instant);
        // instant添加6000秒,返回新的instance
        Instant instant1 = instant.plusSeconds(6000);
        System.out.println("instant after 6000 seconds: " + instant1);
        // 根据字符串解析Instant对象
        Instant instant2 = Instant.parse("2019-12-20T08:59:18.681128Z");
        System.out.println("instant2: " + instant2);
        // 在instance2的基础上添加2小时20分
        Instant instant3 = instant2.plus(Duration.ofHours(2).plusMinutes(20));
        System.out.println("instant3: " + instant3);
        // 获取instant2五天前时刻
        Instant instant4 = instant2.minus(Duration.ofDays(5));
        System.out.println("instant4: " + instant4);
    }

    @Test
    public void test_time_Duration() {
        Duration duration = Duration.ofSeconds(6000); // 会进行四舍五入
        System.out.println("6000秒相当于: " + duration.toMinutes() + "分钟");
        System.out.println("6000秒相当于: " + duration.toHours() + "小时");
        System.out.println("6000秒相当于: " + duration.toDays() + "天");
        // 在Clock基础上添加八小时
        Duration plus8ZoneDuration = Duration.ofHours(8);
        Clock clock = Clock.systemUTC();
        Clock clock1 = Clock.offset(clock, plus8ZoneDuration);
        System.out.println("东八时区时间,为: " + clock1.instant());
    }
    @Test
    public void test_time_Clock() {
        // -------Clock-------------
        Clock clock = Clock.systemUTC();
        System.out.println("当前时刻为: " + clock.instant());
        // 获取clock对应毫秒数,与System.currentTimeMills()相同
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test_date() {
        Date date = new Date();
        Date date2 = new Date(System.currentTimeMillis() + 100);
        System.out.println("date2:" + date2);
        System.out.println("date.compareTo(date2): " + date.compareTo(date2));
        System.out.println("date.before(date2): " + date.before(date2));
    }

    @Test
    public void test_calendar() {
        Calendar calendar = Calendar.getInstance();
        // calendar和date的相互转换
        Date date = calendar.getTime();
        calendar.setTime(date);
    }
}
