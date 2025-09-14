package RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {

    @Test
    public void delete(){

        given()
                .when()
                .delete("https://petstore.swagger.io/v2/pet/1")
                .then()
                .statusCode(404)
                .log().all();
    }
}
