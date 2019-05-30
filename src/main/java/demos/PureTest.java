package demos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PureTest {

    public static void main(String[] args) {
        String str = "  <context-param>\n" +
                "                <param-name>encode</param-name>\n" +
                "                <param-value>UTF-8</param-value>\n" +
                "          </context-param>\n" +
                "\n" +
                "        String value=sc.getInitParameter(name);";
        str = getTagString(str);
        System.out.println(str);

    }

    public static String getTagString(String str){
        String left = "<";
        String replceLeft = "&lt;";
        String right = ">";
        String replceRight = "&gt;";
        str = str.replaceAll(left,replceLeft);
        str = str.replaceAll(right,replceRight);
        return str;
    }


}
