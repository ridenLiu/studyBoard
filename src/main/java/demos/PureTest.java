package demos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PureTest {

    public static void main(String[] args) {
        String str = "<web-app>\n" +
                "<display-name>Archetype Created Web Application</display-name>\n" +
                "<servlet>\n" +
                "  <servlet-name>RidenServlet</servlet-name>\n" +
                "  <servlet-class>com.riden.tomtest.RidenServlet</servlet-class>\n" +
                "  <load-on-startup>1</load-on-startup>\n" +
                "</servlet>\n" +
                "<servlet-mapping>\n" +
                "  <servlet-name>RidenServlet</servlet-name>\n" +
                "  <url-pattern>/hello</url-pattern>\n" +
                "</servlet-mapping>\n" +
                "</web-app>";
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
