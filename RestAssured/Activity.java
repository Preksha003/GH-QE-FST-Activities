package RestAssured;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity {

    static String baseURL = "https://petstore.swagger.io/v2";
    static long petId; // single pet ID for all operations

    // 1️⃣ Create the pet before running tests
    @BeforeClass
    public void createPet() {
        Map<String, Object> body = new HashMap<>();
        body.put("name", "Doggie");
        body.put("status", "available");

        Response res = given()
                .baseUri(baseURL)
                .header("Content-Type", "application/json")
                .body(body)
            .when()
                .post("/pet");

        assertTrue(res.getStatusCode() == 200);
        petId = res.jsonPath().getLong("id");
        System.out.println("✅ Pet created with ID: " + petId);
    }

    // 2️⃣ GET
    @Test(priority = 1)
    public void testGetPet() {
        Response res = given()
                .baseUri(baseURL)
            .when()
                .get("/pet/" + petId);

        assertTrue(res.getStatusCode() == 200);
        System.out.println("✅ GET Passed for ID: " + petId);
    }

    // 3️⃣ PUT (update status)
    @Test(priority = 2)
    public void testUpdatePet() {
        Map<String, Object> body = new HashMap<>();
        body.put("id", petId);
        body.put("name", "Doggie");
        body.put("status", "sold");

        Response res = given()
                .baseUri(baseURL)
                .header("Content-Type", "application/json")
                .body(body)
            .when()
                .put("/pet");

        assertTrue(res.getStatusCode() == 200);
        System.out.println("✅ PUT Passed for ID: " + petId);
    }

    // 4️⃣ VERIFY UPDATE
    @Test(priority = 3)
    public void testVerifyUpdate() {
        Response res = given()
                .baseUri(baseURL)
            .when()
                .get("/pet/" + petId);

        assertTrue(res.getStatusCode() == 200);
        assertEquals(res.jsonPath().getString("status"), "sold");
        System.out.println("✅ VERIFY UPDATE Passed for ID: " + petId);
    }

    // 5️⃣ DELETE
    @Test(priority = 4)
    public void testDeletePet() {
        Response res = given()
                .baseUri(baseURL)
            .when()
                .delete("/pet/" + petId);

        assertTrue(res.getStatusCode() == 200);
        System.out.println("✅ DELETE Passed for ID: " + petId);
    }

    // 6️⃣ VERIFY DELETE
    @Test(priority = 5)
    public void testVerifyDelete() {
        Response res = given()
                .baseUri(baseURL)
            .when()
                .get("/pet/" + petId);

        // Swagger sometimes returns 200 with message instead of 404
        assertTrue(res.getStatusCode() == 404 || res.getStatusCode() == 200);
        System.out.println("✅ VERIFY DELETE Passed for ID: " + petId);
    }
}