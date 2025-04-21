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

public class DeleteUserTest extends BaseTest {

    private User userToDelete;

    @BeforeClass
    public void setupUser() {
        List<User> users = TestDataReader.readUsers("userData.json");
        userToDelete = users.get(0);

        // Ensure the user exists before attempting deletion
        given()
            .contentType("application/json")
            .body(userToDelete)
        .when()
            .post("/user")
        .then()
            .statusCode(200);
    }

    @Test
    public void testDeleteUser() {
        given()
        .when()
            .delete("/user/" + userToDelete.getUsername())
        .then()
            .statusCode(200)
            .body("message", equalTo(userToDelete.getUsername()));
    }
}
