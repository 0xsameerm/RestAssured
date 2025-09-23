package RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.auth;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {

    @Test
    public void BasicAuth(){

        given()
                .auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();

    }

    @Test
    public void DigestAuth(){

        given()
                .auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();

    }

    @Test
    public void PreemptiveAuth(){

        given()
                .auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();

    }

    public void testBearerToken(){

        String BearerToken = "1eon2ro3r4ogg3jhkkrl23r";
        given()
                .header("Authorization","Bearer "+BearerToken)
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .log().all();

    }

    public void OAuth1(){
        given()
                .auth().oauth("consumerKey","consumerSecret","accessToken",
                        "secretToken")
                .when()
                .get("url")
                .then()
                .log().all();
    }

    public void OAuth2(){
        given()
                .auth().oauth2("secretToken")
                .when()
                .get("url")
                .then()
                .log().all();
    }


    public void APIKey(){
        given()
                .queryParam("appid","igergrkfieufveiwf")//appid is api key
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }



}
