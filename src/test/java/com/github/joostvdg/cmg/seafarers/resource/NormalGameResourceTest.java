package com.github.joostvdg.cmg.seafarers.resource;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class NormalGameResourceTest {

  @Test
  public void testNormalGameEndpoint() {
    given().when().get("/api/normal").then().statusCode(200);
  }
}
