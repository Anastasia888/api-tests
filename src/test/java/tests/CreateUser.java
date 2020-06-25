package tests;

import consants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUser {

    @Test
    public void createUser() {
        String name="test";
        String job="test1";
        User user = new User(name,job);
        RestAssured.baseURI = Endpoints.BASE_URL;
        RequestSpecification request = RestAssured
                .given()
                .header("Content-Type", "application/json");
        Response response = request.body(user)
                .post("");
        assertEquals(response.getStatusCode(), 201);
        assertEquals(user.getName().toLowerCase(), name);
    }
}
