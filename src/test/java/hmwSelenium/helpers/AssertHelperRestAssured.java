package hmwSelenium.helpers;

import hmwSelenium.tests.TestBase;
import io.restassured.RestAssured;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;



public class AssertHelperRestAssured {

    public static void main(String[] args) {


    }

    @Test
    public static void getgoods() {
        GoodsPojo goodstaken = new GoodsPojo();

        List<GoodsPojo> goods = given()
              .baseUri("http://localhost:8080")
              .basePath("/api/goods")
              .contentType(ContentType.JSON)
              .when().get()
              .then().log().all()
              .statusCode(200)
              .contentType("application/json")
           //   .body("isEmpty()", Matchers.is(false))
                  .extract().jsonPath().getList("goods", GoodsPojo.class);




    }

    public List <String> parseCode (List<GoodsPojo> goods){
        GoodsPojo goodstaken = new GoodsPojo();
        List <String> parser = Collections.singletonList(goodstaken.getPseudoCode());
        return parser;

    }
}
