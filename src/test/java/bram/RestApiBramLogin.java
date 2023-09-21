package bram;

import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.notNullValue;

public class RestApiBramLogin {


    @Test
    void successfulLoginUserTest() {

        RestAssured.registerParser("text/plain", Parser.JSON);
        String data = "{ \"login\": \"admin\", \"pass\": \"autoplay\" }";
       Spec.request

                .body(data)
                .when()
                .post("/core/login")
                .then()
               .spec(Spec.responseSpec)
                //.log().all()
                .body("accessToken", notNullValue());
    }
}
