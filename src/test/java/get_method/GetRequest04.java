package get_method;

import base_urls.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetRequest04 extends DummyBaseUrl {

    @Test
    public void getTest(){
        spec.pathParams("first","employees");
        Response response = given().
                                spec(spec).
                                accept("application/json").
                            when().
                                get("/{first}");

        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id", Matchers.hasSize(24)).
                body("data.employee_salary",Matchers.hasItem(85600)).
                body("data.id", Matchers.hasItems(1,2,3));

    }
}
