package hmwSelenium.helpersutils;

import hmwSelenium.pages.LPpage;
import hmwSelenium.tests.TestBase;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;


public class AssertHelperRestAssured extends TestBase {



    public List<GoodsPojo> getgoods() {
           //  GoodsPojo goodstaken = new GoodsPojo();

        List<GoodsPojo> goods = given()
                .baseUri("http://localhost:8080")
                .basePath("/api/goods")
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().all()
                .statusCode(200)
                .contentType("application/json")
                .body("isEmpty()", Matchers.is(false))
                .extract().jsonPath().getList("goods", GoodsPojo.class);

        return goods;

        }
    public List<GoodsPojo> goodsChangeCode(List<GoodsPojo> goods){

        for(int i =0; i< goods.size(); i++){
           String k = goods.get(i).getCode();
           int k2 = Integer.parseInt(k.replaceAll("[^0-9]", ""));
           k = String.valueOf(k2);
           goods.get(i).setCode(k);

        }
       return goods;
    }

    public static void assertPageLoadedByTitleText(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }
    public static void assertHelperForPojo(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }


    public void checkEqualness(List<GoodsPojo> goods) {
        LPpage lpPage = new LPpage(driver);

            for (int i = 0; i < goods.size(); i++) {
                try {
                    lpPage.search(goods.get(i).getName());
                 //   Assert.assertTrue();
                   Assert.assertEquals(lpPage.deferCurrentElementName(goods.get(i).getName()), goods.get(i).getName());
                   Assert.assertEquals(lpPage.textAvailability(),goods.get(i).getAvailability());
                   Assert.assertEquals(lpPage.getConvertedCode(),goods.get(i).getCode());

                } catch(NoSuchElementException e) {
                    System.out.println("Test is failed, element"+ goods.get(i).getName());
                }
            }
        }
        @Test
        public void getAndcompareRetrievedData() throws IOException {
            checkEqualness(goodsChangeCode(getgoods()));
    }

}
