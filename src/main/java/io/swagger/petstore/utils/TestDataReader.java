package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.petstore.model.User;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class TestDataReader {

    public static List<User> readUsers(String resourcePath) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = TestDataReader.class.getClassLoader().getResourceAsStream(resourcePath);) {
            
            if (inputStream == null) {
                throw new RuntimeException("Resource not found: " + resourcePath);
            }
            return Arrays.asList(mapper.readValue(inputStream, User[].class));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read user data from: " + resourcePath, e);
        }
    }
}
