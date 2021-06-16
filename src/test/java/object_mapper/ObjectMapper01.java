package object_mapper;

import base_urls.JsonBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ObjectMapper01 extends JsonBaseUrl {
    @Test
    public void getTest(){
        spec.pathParams("first","todos","second",10);

        String expected = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 10,\n" +
                "    \"title\": \"illo est ratione doloremque quia maiores aut\",\n" +
                "    \"completed\": true\n" +
                "}";

        HashMap<String,Object> expectedData = JsonUtil.convertJsonToJava(expected, HashMap.class);

        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
        response.prettyPrint();

        HashMap<String,Object> actualData = JsonUtil.convertJsonToJava(response.asString(),HashMap.class);

        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));


    }
}
