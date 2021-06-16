package get_method;

import base_urls.OpenWeatherBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest10 extends OpenWeatherBaseUrl {
    @Test
    public void getTest(){
        spec.pathParams("first","data",
                "second","2.5",
                "third","weather").
             queryParams("q","London",
                        "appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

        response.prettyPrint();




    }

}
