package hmwSelenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.NoSuchElementException;

public class LPpage extends BasePage {

    WebDriverWait wait;

    public LPpage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(xpath = "//div[@class='logo']")
    private WebElement LPlogo;
    @FindBy(xpath = "//a[@class='logo']")
    private WebElement Pagelogo;
    @FindBy(xpath = "//div[@class='top-block top-block--search']/form/div/input[@id='search-input']")
    private WebElement searchfield;
    //  @FindBy(xpath = "//span[@class='product-thumb__name' and text()='" + name + "']")
    //  private WebElement searchfield;
    @FindBy(xpath = "//span[@class='product-thumb__availability product-thumb__availability--available']")
    private WebElement availability;
    @FindBy(xpath = "//span[@class='product-thumb__id']")
    private WebElement pseudoCode;

    public void search(String name) {
        waitForLoad(searchfield, wait);
        searchfield.clear();
        searchfield.sendKeys(name);
        searchfield.submit();
        searchfield.clear();
        //waitForLoad(Pagelogo, wait);

    }

    public void compare() {

    }

    public String deferCurrentElementName(String name, SoftAssert softAssert) {
        WebElement nameOnElement;
        waitForLoad(Pagelogo, wait);
        try {
            nameOnElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='product-thumb__name' and text()='" + name + "']")));
            return nameOnElement.getText();
        } catch (TimeoutException | NoSuchElementException e) {
            softAssert.fail("wasn't possible to find:" + name);
        }
        return null;
    }




    public String textAvailability() {
        return availability.getText();
    }

    public String getConvertedCode() {
        String k = pseudoCode.getText();
        int k2 = Integer.parseInt(k.replaceAll("[^0-9]", ""));
        return String.valueOf(k2);

    }
}
//span[@class='product-thumb__name' and text()='Видеокарта Inno3D NVIDIA CMP 90-HX MINING CARD (ACMP-90HX-3FS, 288-9N612-101KT)']