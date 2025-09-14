package RestAssured;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequests {

    //using json.org library
    @Test
    public void postmethod1(){
        JSONObject data = new JSONObject();
        data.put("id","2");
        data.put("name","Dony");

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .body("name",equalTo("Dony"))
                .body("id",equalTo(2))
                .log().all();
    }

    //Using POJO class
    @Test
    public void postmethod2(){
        POJO_PostRequests obj = new POJO_PostRequests();
        obj.setId("3");
        obj.setName("Jimmy");

        given()
                .contentType("application/json")
                .body(obj)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .body("name",equalTo("Jimmy"))
                .body("id",equalTo(3))
                .log().all();

    }

    //using external json file
    @Test
    public void postmethod3() throws FileNotFoundException {

        File file = new File(".\\body.json");
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject object = new JSONObject(jt);



        given()
                .contentType("application/json")
                .body(object.toString())
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .body("name",equalTo("teddy"))
                .body("id",equalTo(4))
                .log().all();
    }


}
