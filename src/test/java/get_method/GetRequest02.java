package get_method;

import base_urls.HerokuBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetRequest02 extends HerokuBaseUrl {

    @Test
    public void getTest(){

        spec.pathParams("first", "booking", "second", 1001);
        Response response = given().
                                spec(spec).
                                accept("application/json").
                            when().
                                get("/{first}/{second}");

        response.then().
                assertThat().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");

        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertEquals(response.getHeader("Server"), "Cowboy");

        System.out.println("Time: " + response.getTime());
    }
}
