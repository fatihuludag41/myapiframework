package ApiPractices;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    /*When I send a GET request to the URL https://api-techproed-test.herokuapp.com/courses
    * Then HTTP Status code should be 200
    * And Content Type should be JSON
    * And Status line should be HTTP/1.1 200 OK
    * */

    @Test
    public void getTest01(){
        Response response = given().
                                    accept("application/json").
                            when().
                                    get("https://api-techproed-test.herokuapp.com/courses");

//        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Content type: " + response.getContentType().split(";")[0]);
        System.out.println("Status line: " + response.getStatusLine());
        System.out.println("All headers:\n" + response.getHeaders());
        System.out.println("Server: " + response.getHeader("Server"));
        System.out.println("Time: " + response.getTime());
    }
}
