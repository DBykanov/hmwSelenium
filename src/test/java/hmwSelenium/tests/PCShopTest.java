package hmwSelenium.tests;

import hmwSelenium.helpersutils.AssertHelperRestAssured;
import hmwSelenium.helpersutils.Utils;
import hmwSelenium.pages.LPpage;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class PCShopTest extends TestBase{

    private static final Logger LOG = LogManager.getLogger(PCShopTest.class.getName());

    @Test
    public void findAndCompare () throws IOException {
        LOG.debug("Перехожу на ЛП страницу");
        driver.get(Utils.props());
        AssertHelperRestAssured help = new AssertHelperRestAssured();
        help.getAndcompareRetrievedData();
        LOG.info("тест пройден");
    }

}
