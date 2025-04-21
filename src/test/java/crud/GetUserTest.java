package crud;

import base.BaseTest;
import io.restassured.RestAssured;
import io.swagger.petstore.model.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestDataReader;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUserTest extends BaseTest {

    @Test(dataProvider = "userData")
    public void testCreateUser(User user) {
        given()
            .contentType("application/json")
            .body(user)
        .when()
            .post("/user")
        .then()
            .statusCode(200)
            .body("message", equalTo(String.valueOf(user.getId())));
    }

    @DataProvider(name = "userData")
    public Object[][] userData() {
        List<User> users = TestDataReader.readUsers("userData.json");
        return users.stream().map(u -> new Object[]{u}).toArray(Object[][]::new);
    }
}
