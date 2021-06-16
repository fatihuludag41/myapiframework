package get_method;

import base_urls.HerokuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 extends HerokuBaseUrl {

    @Test
    public void getTest(){
        spec.pathParams("first","booking").
                queryParams("firstname","Sally","totalprice",370);
        Response response = given().
                                spec(spec).
                                contentType(ContentType.JSON).
                            when().
                                get("/{first}");

        response.prettyPrint();

    }
}
