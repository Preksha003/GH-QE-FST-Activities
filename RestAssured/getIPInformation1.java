package RestAssured;


import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getIPInformation1 {

    // Base URL (NO path param here)
    final static String ROOT_URI = "http://ip-api.com/json";

    @Test
    public void getIPInformation() {

        Response response =
                given()
                        .contentType(ContentType.JSON)
                .when()
                        // Add query parameter
                        .queryParam("fields", "query,country,city,timezone")
                        // Add IP in URL
                        .get(ROOT_URI + "/125.219.5.94");

        // Print formatted JSON
        System.out.println(response.getBody().asPrettyString());
    }
}

