package org.keycube.fiasservice.internal.resource;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class InternalResourceTest {

  @Test
  public void findByStr() {
    JsonObject query =
        Json.createObjectBuilder()
            .add("query", "Ненецкий АО, Заполярный р-н, поселок Красное, ул Спортивная")
            .build();
    given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(query.toString())
        .when()
        .post("/fias-reactive/internal/find-by-str")
        .then()
        .statusCode(200);
  }

  @Test
  public void findById() {
    JsonObject query =
        Json.createObjectBuilder().add("query", "3db18d9f-6cd3-4ca0-852c-933489cfdff9").build();
    given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(query.toString())
        .when()
        .post("/fias-reactive/internal/find-by-id")
        .then()
        .statusCode(200);
  }

  @Test
  @Disabled
  public void findByKladr() {
    JsonObject query = Json.createObjectBuilder().add("query", "83001000018001700").build();
    given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(query.toString())
        .when()
        .post("/fias-reactive/internal/find-by-kladr")
        .then()
        .statusCode(200);
  }
}
