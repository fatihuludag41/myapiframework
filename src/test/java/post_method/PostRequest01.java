package post_method;

import base_urls.HerokuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuappTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostRequest01 extends HerokuBaseUrl {
    @Test
    public void postTest(){
        HerokuappTestData sentJson = new HerokuappTestData();

        spec.pathParams("first","booking");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(sentJson.expectedDataSetUp()).when().post("/{first}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();

        assertEquals(sentJson.expectedDataSetUp().get("firstname"),json.getString("booking.firstname"));
        assertEquals(sentJson.expectedDataSetUp().get("lastname"),json.getString("booking.lastname"));
        assertEquals(sentJson.expectedDataSetUp().get("totalprice"),json.getInt("booking.totalprice"));
        assertEquals(sentJson.expectedDataSetUp().get("depositpaid"),json.getBoolean("booking.depositpaid"));
        assertEquals(sentJson.bookingDatesSetUp().get("checkin"),json.getString("booking.bookingdates.checkin"));
        assertEquals(sentJson.bookingDatesSetUp().get("checkout"),json.getString("booking.bookingdates.checkout"));
    }

}
