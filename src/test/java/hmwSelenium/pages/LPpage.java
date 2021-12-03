package hmwSelenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LPpage extends BasePage {


    WebDriverWait wait;


    @FindBy(xpath = "//div[@class='logo']")
    private WebElement LPlogo;
    @FindBy(xpath = "//a[@class='logo']")
    private WebElement Pagelogo;
    @FindBy(xpath = "//div[2]//input[@class='search-form__input' and @type='search']")
    private WebElement searchfield;
  //  @FindBy(xpath = "//span[@class='product-thumb__name' and text()='" + name + "']")
  //  private WebElement searchfield;

  public LPpage(WebDriver driver) {
      super(driver);
      PageFactory.initElements(driver, this);
      //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  }



    public void search(String name) {
      searchfield.clear();
      searchfield.sendKeys(name);
      searchfield.submit();
      //waitForLoad(Pagelogo, wait);

    }


    public void compare() {

    }

    public WebElement deferCurrentElementName(String name) {
        WebElement contacts2;
        return  contacts2 = driver.findElement(By.xpath("//span[@class='product-thumb__name' and text()='" + name + "']"));
    }

}
