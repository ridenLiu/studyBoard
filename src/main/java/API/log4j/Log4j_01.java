package API.log4j;



import java.io.File;

public class Log4j_01 {

    //private static Logger logger = Logger.getLogger(Login_01.class);

    public static void main(String[]args){
        File propertiesConfigFile = new File("log4j.properties");
        File XmlConfigFile = new File("log4j.xml");
        System.out.println(propertiesConfigFile.exists());


    }

}
