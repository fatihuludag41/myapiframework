package ApiPractices;

import BaseUrls.HerokuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static  org.hamcrest.Matchers.*;

public class GetRequest06 extends HerokuBaseUrl {

    @Test
    public void getTest(){
        spec.pathParams("first","booking","second",5);
        Response response = given().
                                spec(spec).
                            when().
                                get("/{first}/{second}");

        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Mark"),
                        "lastname", "Ericsson",
                        "totalprice",524);
    }

}
