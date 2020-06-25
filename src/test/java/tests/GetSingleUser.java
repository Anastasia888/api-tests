package tests;

import consants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetSingleUser {

    @Test
    public void getUser() {
        RestAssured.baseURI = Endpoints.BASE_URL;
        RequestSpecification request = RestAssured
                .given()
                .contentType(ContentType.JSON);
        Response response = request.get("?id=12");
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200);
    }

}
