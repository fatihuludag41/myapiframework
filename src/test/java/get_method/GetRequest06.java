package get_method;

import base_urls.HerokuBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest06 extends HerokuBaseUrl {

    @Test
    public void getTest(){
        spec.pathParams("first","booking","second",5);
        Response response = given().
                                spec(spec).
                            when().
                                get("/{first}/{second}");

//        response.then().
//                statusCode(200).
//                contentType(ContentType.JSON).
//                body("firstname", equalTo("Mary"),
//                        "lastname", equalTo("Ericsson"),
//                        "totalprice",equalTo(257),
//                        "depositpaid",equalTo(true),
//                        "bookingdates.checkin",equalTo("2018-07-07"),
//                        "bookingdates.checkout",equalTo("2018-09-09"));

        System.out.println("Time: " + response.getTime() + " ms");

        JsonPath json = response.jsonPath();

//        assertEquals("Status code does not match!",200, response.getStatusCode());
//        assertEquals("First name does not match!","Mary", json.getString("firstname"));
//        assertEquals("Last name does not match!","Jones", json.getString("lastname"));
//        assertEquals("Check in date does not match!","2020-06-24", json.getString("bookingdates.checkin"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(json.getString("firstname").equals("Marky"));
        softAssert.assertTrue(json.getInt("totalprice")==1745);
        softAssert.assertTrue(json.getBoolean("depositpaid")==false);

        softAssert.assertAll();




    }

}
