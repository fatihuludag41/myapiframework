package get_method;

import base_urls.JsonBaseUrl;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class GetRequest03 extends JsonBaseUrl {

    @Test
    public void getTest(){
        spec.pathParams("first","todos","second","23");

        Response response = given().
                                spec(spec).
                                accept("application/json").
                            when().
                                get("/{first}/{second}");

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId", equalTo(2));

        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("\"userId\": 2"));
    }
}
