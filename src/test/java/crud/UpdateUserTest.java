package crud;

import base.BaseTest;
import io.restassured.RestAssured;
import io.swagger.petstore.model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestDataReader;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserTest extends BaseTest {

    private User originalUser;
    private User updatedUser;

    @BeforeClass
    public void prepareUsers() {
        List<User> users = TestDataReader.readUsers("userData.json");
        originalUser = users.get(0);

        // Ensure the original user exists
        given()
            .contentType("application/json")
            .body(originalUser)
        .when()
            .post("/user")
        .then()
            .statusCode(200);

        // Clone and modify for update
        updatedUser = new User();
        updatedUser.setId(originalUser.getId());
        updatedUser.setUsername(originalUser.getUsername());
        updatedUser.setFirstName("UpdatedFirst");
        updatedUser.setLastName("UpdatedLast");
        updatedUser.setEmail("updated@example.com");
        updatedUser.setPassword("newpassword");
        updatedUser.setPhone("0001112222");
        updatedUser.setUserStatus(2);
    }

    @Test
    public void testUpdateUser() {
        given()
            .contentType("application/json")
            .body(updatedUser)
        .when()
            .put("/user/" + originalUser.getUsername())
        .then()
            .statusCode(200)
            .body("message", equalTo(String.valueOf(updatedUser.getId())));

        // Verify update
        given()
        .when()
            .get("/user/" + updatedUser.getUsername())
        .then()
            .statusCode(200)
            .body("firstName", equalTo("UpdatedFirst"))
            .body("email", equalTo("updated@example.com"));
    }
}
