package hmwSelenium.tests;

import hmwSelenium.helpersutils.AssertHelperRestAssured;
import hmwSelenium.helpersutils.Utils;
import hmwSelenium.pages.LPpage;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class PCShopTest extends TestBase{

    private static final Logger LOG = LogManager.getLogger(PCShopTest.class.getName());

    @BeforeTest
    public void setupProps() throws IOException{
        Utils.initConfigProp();
    }

    @Test
    public void findAndCompare () {
        LOG.debug("Перехожу на ЛП страницу");
        //driver.get(Utils.configProp.getProperty("url"));
        driver.get("https://pcshop.ua/");
        LPpage lpPage = new LPpage(driver);
        AssertHelperRestAssured help = new AssertHelperRestAssured();
        help.getAndcompareRetrievedData(lpPage);
        LOG.info("тест пройден");
    }

}
