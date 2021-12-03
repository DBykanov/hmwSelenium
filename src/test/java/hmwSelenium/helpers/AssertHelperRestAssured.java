package hmwSelenium.helpers;

import hmwSelenium.pages.BasePage;
import hmwSelenium.pages.LPpage;
import hmwSelenium.tests.TestBase;
import io.restassured.RestAssured;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;



public class AssertHelperRestAssured extends TestBase{

    LPpage lpPage = new LPpage(driver);


    public static void main(String[] args){
    }

    @Test
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
        @DataProvider
        getData() {

        }


    public static void assertPageLoadedByTitleText(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }
    public static void assertHelperForPojo(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public void checkEqualness(List<GoodsPojo> goods) {
        for(int i = 0; i<goods.size(); i++) {
            lpPage.search(goods.get(i).getName());
         Assert.assertEquals(lpPage.deferCurrentElementName(goods.get(i).getName()),goods.get(i).getName());

        }
          //  goods.get().getName();
          //  search(name)
           // assertequals(LPpage.defercurentelementname(goods.get(l).getName()), goods.get(l).getName() )
            //  assertequals(y, goods.get(l).getAvailability() )
            //  assertequals(z, goods.get(l).getcode() )
}


        public void test() {
            checkEqualness(getgoods());
    }

}