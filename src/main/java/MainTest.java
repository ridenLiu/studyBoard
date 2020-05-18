import com.alibaba.fastjson.JSONObject;
import utils.FileUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static java.io.File.separator;

public class MainTest {


    public static void main(String[] args) throws IOException {
        String s = separator;
        String filePath = "main" + s + "resources" + s + "json" + s + "testFile.json";
//        String res = FileUtil.getJsonStr(filePath);
//        System.out.println("res : ");
        System.out.println(filePath);
    }

    static void test1() throws IOException {
        JSONObject json = new JSONObject();
        JSONObject option = new JSONObject();
        option.put("name", "统建项目曲线");
        option.put("id", new Date().getTime());

        json.put("name", "riden");
        json.put("age", 21);
        json.put("address", "北京1111");
        json.put("option", option);

        String s = separator;
        String filePath = "main" + s + "resources" + s + "json" + s + "testFile.json";
        FileUtil.saveJsonFile(filePath, json);
        System.out.println("over");
    }


}


