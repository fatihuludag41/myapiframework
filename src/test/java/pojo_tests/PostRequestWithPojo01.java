package pojo_tests;

import base_urls.JsonBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.TodosPojo;
import utils.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo01 extends JsonBaseUrl {
    @Test
    public void postTest(){
        spec.pathParams("first","todos");

        TodosPojo expectedPojo = new TodosPojo(21,"sup man?", false);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedPojo).post("/{first}");
        System.out.println("Coming from Response:");
        response.prettyPrint();

        // Assertions
        // 1. way: Use GSON to convert response body to TodosPojo
        TodosPojo actualData = response.as(TodosPojo.class);
        System.out.println("Coming from GSON: " + actualData);
        Assert.assertEquals(expectedPojo.getUserId(), actualData.getUserId());

        // 2. way: Use ObjectMapper
        TodosPojo actualData2 = JsonUtil.convertJsonToJava(response.asString(),TodosPojo.class);
        System.out.println("Coming from ObjectMapper: " + actualData2);
        Assert.assertEquals(expectedPojo.getUserId(), actualData2.getUserId());



    }

}
