package hmwSelenium.tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import hmwSelenium.pages.LPpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {



    public static final String HOST = "localhost";
    public static final int PORT = 8080;
    /*
    public static final String URL = String.format("http://%s:%d/%s", HOST, PORT, "%s");
    String apiURL = String.format(TestBase.URL, "api/goods");
 */

    public static final WireMockServer WIRE_MOCK_SERVER = new WireMockServer(PORT);
    public WebDriver driver;



    @BeforeTest
    public void setup() {

        //  WebDriverManager.firefoxdriver().setup();
        //   WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //   driver = new FirefoxDriver();

        if (driver == null) {
            driver = new ChromeDriver();
        }

        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //landingPage lp = new LPpage(driver);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
