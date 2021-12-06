package hmwSelenium.helpersutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Props {
    public static Properties configProp;
    public static String propertiesFilePath = "C:\\Users\\Power1nside\\IdeaProjects\\hmwSelenium\\src\\test\\resources\\properties";

    public static void initConfigProp() throws IOException {
        configProp = new Properties();
        configProp.load(new FileInputStream(propertiesFilePath));
    }

}