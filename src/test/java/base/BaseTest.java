package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}
