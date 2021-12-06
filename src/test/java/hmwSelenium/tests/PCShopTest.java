package hmwSelenium.tests;

import hmwSelenium.helpersutils.AssertHelperRestAssured;
import hmwSelenium.helpersutils.Props;
import hmwSelenium.pages.LPpage;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class PCShopTest extends TestBase{

    private static final Logger LOG = LogManager.getLogger(PCShopTest.class.getName());

/*
    @BeforeTest
    public void setupProps() throws IOException{
        Props.initConfigProp();
    }

 */
    @Test
    public void findAndCompare () {
        LOG.debug("Перехожу на ЛП страницу");
        driver.get(Props.configProp.getProperty("lpURL"));
        LPpage lpPage = new LPpage(driver);
        AssertHelperRestAssured help = new AssertHelperRestAssured();
        help.getAndcompareRetrievedData(lpPage);
        LOG.info("тест пройден");
    }

}
