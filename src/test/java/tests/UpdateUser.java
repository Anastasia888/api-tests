package tests;

import consants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateUser {
    @Test
    public void updateUserDetails() {
        String name="test3456";
        String job="test";
        User user = new User(name, job);
        RestAssured.baseURI = Endpoints.BASE_URL;
        RequestSpecification request = RestAssured
                .given()
                .header("Content-Type", "application/json");
        Response response = request.body(user)
                .put("/12");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(user.getName().toLowerCase(), name);


    }
}
