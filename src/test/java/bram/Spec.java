package bram;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.containsString;

public class Spec {



     public static RequestSpecification request = with()
             .baseUri("http://Server_ip")
             .basePath("/api")
             .contentType(JSON)
             .log().all();

     public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
             .expectStatusCode(200)
        //     .expectBody(containsString("success"))
             .build();

}
