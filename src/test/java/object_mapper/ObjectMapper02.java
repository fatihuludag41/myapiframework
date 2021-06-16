package object_mapper;

import base_urls.HerokuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ObjectMapper02 extends HerokuBaseUrl {
    @Test
    public void getTest(){
        spec.pathParams("first","booking", "second",1);
        String expected = "{\n" +
                "    \"firstname\": \"Susan\",\n" +
                "    \"lastname\": \"Jones\",\n" +
                "    \"totalprice\": 620,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2021-01-02\",\n" +
                "        \"checkout\": \"2021-01-25\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        HashMap<String,Object> expectedData = JsonUtil.convertJsonToJava(expected,HashMap.class);

        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
        response.prettyPrint();

        HashMap<String,Object> actualData = JsonUtil.convertJsonToJava(response.asString(),HashMap.class);

        Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));

        // booking dates 1. method
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));

        // booking dates 2. method
        Assert.assertEquals(expectedData.get("bookingdates.checkin"),actualData.get("bookingdates.checkin"));
        Assert.assertEquals(expectedData.get("bookingdates.checkout"),actualData.get("bookingdates.checkout"));

        Assert.assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
    }
}
