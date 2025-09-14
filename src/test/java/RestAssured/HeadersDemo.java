package RestAssured;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersDemo {

    @Test
    public void testHeaders(){

        given()
                .when()
                .get("https://www.google.com")
                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .and()
                .header("Server","gws");
    }

    @Test
    public void getHeader(){
        Response res = given()
                .when()
                .get("http://www.google.com");

        String heederInfo = res.getHeader("Content-Type");
        System.out.println(heederInfo);

        //get all headers
        Headers myHeader = res.getHeaders();
        for(Header hd : myHeader){
            System.out.println(hd.getName()+" "+hd.getValue());
        }
    }
}
