package RestAssured;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakeDataGenerator {

    @Test
    public void fakerdatagenerator(){

        Faker faker = new Faker();

        String FullName = faker.name().fullName();
        String username = faker.name().username();
        String password = faker.internet().password();
        String email = faker.internet().safeEmailAddress();
        String phoneno = faker.phoneNumber().cellPhone();

        System.out.println("FullName is "+FullName);
        System.out.println("Email is "+email);
    }
}
