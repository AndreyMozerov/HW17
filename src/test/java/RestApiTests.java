
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RestApiTests {

    @Test
   void successfulLoginUserTest() {
      //  String data = "{ \"login\": \"admin\", \"pass\": \"autoplay\" }";
        given()
                .contentType(JSON)
                .body("{ \"login\": \"admin\", \"pass\": \"autoplay\" }")
                .when()
                .post("http://10.0.1.64:8100/api/core/login")
                .then()
                .statusCode(200)
                .body("accessToken", notNullValue());
    }

    @Test
    void singleResourceTest() {
        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.color", is("#C74375"));
    }

    @Test
    void getUserIdNotFound(){
        given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/users/888")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }

    @Test
    void singleUserTest() {
        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/users/3")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.email", is("emma.wong@reqres.in"));
    }
    @Test
    void deleteUserTest() {
        given()
                .log().uri()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }
}

