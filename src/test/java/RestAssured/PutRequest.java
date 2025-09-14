package RestAssured;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutRequest {

    @Test
    public void update(){

        HashMap<String,String> data = new HashMap<>();
        data.put("id","1");
        data.put("name","July");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .log().all();
    }

}
