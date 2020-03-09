package API.digest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileDigest {

    public static void main(String[] args) throws Exception {
        String rightRes = "14F0840DBABC554D43CF3021E04F7B11C7285BD85EE13DFB9D59C0A942BCD515";
        String filePath = "D:\\down_load\\Shadowsocks-4.1.8.0.zip";
        String res = getSHA256FromFile(filePath);
        System.out.println("res: " + res);

    }

    static String getSHA256FromFile(String filePath) throws IOException, NoSuchAlgorithmException {
        File file = new File(filePath);
        // 存在且不是文件夹
        if (!file.exists() || file.isDirectory()) {
            throw new FileNotFoundException("for path: " + filePath);
        }
        int length = (int) file.length();
        byte[] fileByte = new byte[length];
        fileByte = Files.readAllBytes(file.toPath());
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(fileByte);
        String res = byte2Hex(digest.digest());
        return res;
    }

    static String getSHA256FromString(String str) {
        String encodingStr = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(str.getBytes(StandardCharsets.UTF_8));
            encodingStr = byte2Hex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodingStr;
    }


    /**
     *     * 将byte转为16进制
     *     * @param bytes
     *     * @return
     *     
     */
    public static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
