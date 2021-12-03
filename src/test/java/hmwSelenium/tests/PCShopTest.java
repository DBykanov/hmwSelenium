package hmwSelenium.tests;

import hmwSelenium.helpers.AssertHelperRestAssured;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PCShopTest extends TestBase{



    @Test
    public void findAndCompare () {
        driver.get("https://pcshop.ua/");
        AssertHelperRestAssured help = new AssertHelperRestAssured();
        help.test();
    }

}
