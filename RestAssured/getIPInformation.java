package RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getIPInformation {

    // Base URL
    String ROOT_URI = "http://ip-api.com/json/{ipAddress}";

    @Test
    public void getIPInformation() {

        Response response =
                given()
                        .contentType(ContentType.JSON)
                .when()
                        .pathParam("ipAddress", "107.218.134.107")
                        .get(ROOT_URI);

        // Print formatted JSON
        System.out.println(response.getBody().asPrettyString());
    }
}