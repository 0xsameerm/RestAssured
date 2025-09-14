package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class GetRequest {

    public void getRequest(){
        RestAssured.baseURI="https://petstore.swagger.io/v2/";

        RequestSpecification rs = given();
        Response response = rs.request(Method.GET,"pet/1");
        System.out.println(response.asPrettyString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void getRequestBDD(){
        given()
                .baseUri("https://petstore.swagger.io/v2/")
                .when()
                .get("pet/1")
                .prettyPrint();
    }

    @Test
    public void getUser(){

        given()

                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }
}
