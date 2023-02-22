package fun;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Test;

public class GameTests {
    @Test
    public void checkSchema(){


        Response response = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .when().get("http://localhost:8080/game?name=")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200).extract().response();
        GamePojo deserializedResponse=response.as(GamePojo.class);
    }

}
