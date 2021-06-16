package get_method;

import base_urls.HerokuBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest09 extends HerokuBaseUrl {
    @Test
    public void getTest(){
        spec.pathParams("first","booking","second",1);
        Response response = given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

        Map<String,Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin","2016-01-27");
        bookingDates.put("checkout","2020-01-14");

        Map<String,Object> expectedJson = new HashMap<>();
        expectedJson.put("firstname","Mary");
        expectedJson.put("lastname","Ericsson");
        expectedJson.put("totalprice",874.0);
        expectedJson.put("depositpaid",true);
        expectedJson.put("bookingdates",bookingDates);

        System.out.println(expectedJson);

        Map<String,Object> actualJson = response.as(HashMap.class);

        assertEquals(expectedJson.get("firstname"),actualJson.get("firstname"));
        assertEquals(expectedJson.get("lastname"),actualJson.get("lastname"));
        assertEquals(expectedJson.get("totalprice"),actualJson.get("totalprice"));
        assertEquals(expectedJson.get("depositpaid"),actualJson.get("depositpaid"));
        assertEquals(((Map)expectedJson.get("bookingdates")).get("checkin"),((Map)actualJson.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedJson.get("bookingdates")).get("checkout"),((Map)actualJson.get("bookingdates")).get("checkout"));

    }
}
