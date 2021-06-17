package pojo_tests;

import base_urls.HerokuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo02 extends HerokuBaseUrl {
    @Test
    public void postTest(){
        // 1) set the url
        spec.pathParams("first","booking");

        // 2) set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2021-06-15","2021-06-21");
        BookingPojo bookingPojo = new BookingPojo("Erdem","Ozturk",512,true,bookingDates,"Baby toys");
        System.out.println("Coming from Pojo: " + bookingPojo);

        // 3) send the request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(bookingPojo).when().post("/{first}");
        response.prettyPrint();

        // 4) assert with GSON
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println("Coming from GSON: " + actualData);
//        Assert.assertEquals(bookingPojo.getFirstname(),actualData.getFirstname());

        // 5) assert with ObjectMapper
        BookingPojo actualData2 = JsonUtil.convertJsonToJava(response.asString(),BookingPojo.class);
        System.out.println("Coming from ObjectMapper: " + actualData2);

        // 6) assert with JsonPath
        JsonPath json = response.jsonPath();
        System.out.println("Coming from JsonPath: " + json.prettyPrint());
        Assert.assertEquals(bookingPojo.getFirstname(), json.getString("booking.firstname"));

    }
}
