package ApiPractices;

import BaseUrls.HerokuBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest07_v2 extends HerokuBaseUrl {
    @Test
    public void getTest(){
        spec.pathParams("first","booking","second",5);

        Response response = given().
                                spec(spec).
                            when().
                                get("/{first}/{second}");

        response.prettyPrint();

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("firstname","Susan");

        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
    }
}
