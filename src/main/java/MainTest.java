import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        int nums = 0;
        try {
            while (true) {
                Object obj = new Object();
                list.add(obj);
                nums++;
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }finally {
            System.out.println("times: "+nums);
        }

    }
}
