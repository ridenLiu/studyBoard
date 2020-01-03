import oracle.sql.TIMESTAMP;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) throws SQLException {
        TIMESTAMP timestamp = new TIMESTAMP();
        Object obj = (Object)timestamp;
        System.out.println(obj.toString());
    }
}
