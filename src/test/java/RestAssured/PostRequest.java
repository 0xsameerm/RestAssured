package RestAssured;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostRequest {
    int ID;
    @Test
    public void createUser(){
        HashMap<String,String> data = new HashMap<>();
        data.put("id","1");
        data.put("name","johny");

        ID = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .jsonPath().getInt("id");
                /*.then()
                .statusCode(200)
                .log().all();*/
        System.out.println(ID);
    }

}
