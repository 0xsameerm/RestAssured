package RestAssured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Cookies {

    @Test
    public void testCookies(){
        given()
                .when()
                .get("https://www.google.com")
                .then()
                .cookie("NID","525%3Dkg2URSkMpuv4311ZFi9IDxXj-7i4C9G0cHuxWm2nXo_4KZBmTMRdcuZjsZO" +
                        "LGfqqXaX8j3ABJnPILmhZxtFJ7JiZ2wzS65UfSh4jrgf5JVYkG_mw7Xlbvt0KZ9fDwjhB7j6WnJRPQ7s43Xh2BSG3-saDNB" +
                        "WXYi6TXjZgsths2rl7-QTqE4F7SwHhloFfFbqhdZjXQyugoR6Ek9VFlSv6lhsm")
                .log().all();
    }

    @Test
    public void getCookiesInfo(){
        Response res = given()
                .when()
                .get("https://www.google.com");

        String cookieValue = res.getCookie("NID");
        System.out.println("Cookie value is: "+cookieValue);

        //get all cookies info
        Map<String,String> allcookies = res.getCookies();
       // System.out.println(allcookies.keySet());


        for(String k:allcookies.keySet()){
            String cookie = res.getCookie(k);
            System.out.println(k+" "+cookie);
        }
    }
}
