import API.JWT.JwtUtil;
import io.jsonwebtoken.Claims;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;

public class MainTest {

    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "riden");
        map.put("password", "123456");
        map.put("id", "111111");
        String res = JwtUtil.createJWT(10000L, map);
        System.out.println(res);


        // 解密token
        Claims claims = JwtUtil.parseJWT(res,map);
        System.out.println(claims);
    }

    // eyJhbGciOiJIUzI1NiJ9
    // .eyJzdWIiOiJyaWRlbiIsInBhc3N3b3JkIjoiMTIzNDU2IiwiaWQiOiIxMTExMTEiLCJleHAiOjE1ODM0ODQyMjMsImlhdCI6MTU4MzQ4NDIxMywianRpIjoiM2YxY2Y4OTktZjhlOC00ODI3LWE5ODMtZjkxNjg3NjBiYzljIiwidXNlcm5hbWUiOiJyaWRlbiJ9
    // .v0ZAivyiUQ_pckx8g9YDaxD6BPI1TtuYuvug4YzCP6A

}


