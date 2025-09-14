package RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class logging {

    @Test
    public void logging(){
        given()
                .when()
                .get("https://www.google.com")
                .then()
                //.log().headers()
                //.log().body()
                //.log().cookies()
                .log().all();
    }
}
