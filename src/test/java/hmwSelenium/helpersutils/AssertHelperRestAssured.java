package hmwSelenium.helpersutils;

import hmwSelenium.pages.LPpage;
import hmwSelenium.tests.TestBase;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;


public class AssertHelperRestAssured {



    public List<GoodsPojo> getgoods() {
           //  GoodsPojo goodstaken = new GoodsPojo();

        return given()
                .baseUri("http://localhost:8080")
                .basePath("/api/goods")
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().all()
                .statusCode(200)
                .contentType("application/json")
                .body("isEmpty()", Matchers.is(false))
                .extract().jsonPath().getList("goods", GoodsPojo.class);

        }
    public List<GoodsPojo> goodsChangeCode(List<GoodsPojo> goods){

        for (GoodsPojo good : goods) {
            String k = good.getCode();
            int k2 = Integer.parseInt(k.replaceAll("[^0-9]", ""));
            k = String.valueOf(k2);
            good.setCode(k);

        }
       return goods;
    }

    public static void assertPageLoadedByTitleText(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }
    public static void assertHelperForPojo(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }


    public void checkEqualness(List<GoodsPojo> goods, LPpage lpPage) {

        SoftAssert softAssert = new SoftAssert();
        for (GoodsPojo good : goods) {
            lpPage.search(good.getName());
            System.out.println("checking " + good.getName() + " element");
            softAssert.assertEquals(lpPage.deferCurrentElementName(good.getName(), softAssert), good.getName());
            softAssert.assertEquals(lpPage.textAvailability(), good.getAvailability());
            softAssert.assertEquals(lpPage.getConvertedCode(), good.getCode());
        }
        softAssert.assertAll();
        }

        public void getAndcompareRetrievedData(LPpage lpPage) {
            checkEqualness(goodsChangeCode(getgoods()), lpPage);
    }

}
