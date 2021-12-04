package hmwSelenium.helpersutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static Properties configProp;
    public static String propertiesFilePath = "C:\\Users\\Power1nside\\IdeaProjects\\hmwSelenium\\src\\test\\java\\resources\\demo.properties";

    public static String props() throws IOException {
        configProp = new Properties();
        configProp.load(new FileInputStream(propertiesFilePath));
        return configProp.getProperty("url");
    }


   /*
    public static String propsBaseUrl() throws IOException {
        Properties prop = new Properties();
        String baseUrl;
        File file = new File("C:\\Users\\Power1nside\\IdeaProjects\\hmwSelenium\\src\\test\\java\\resources\\demo.properties");
        try (FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
            return baseUrl = prop.getProperty("url");

        }
    }
    */
}