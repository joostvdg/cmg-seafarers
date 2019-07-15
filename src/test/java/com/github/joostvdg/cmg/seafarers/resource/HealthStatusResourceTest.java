package com.github.joostvdg.cmg.seafarers.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HealthStatusResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/health")
          .then()
             .statusCode(200)
             .body(is("{\"status\":\"ok\"}"));
    }

}