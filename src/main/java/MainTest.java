import java.sql.SQLException;
import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args) throws SQLException {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusMonths(1); // 获取上月日期
        int year = localDate.getYear();
        int month = localDate.getMonth().getValue();
        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println(localDate);
    }
}
