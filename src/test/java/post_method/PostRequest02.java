package post_method;

import base_urls.JsonBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.JsonPlaceHolderTodoData;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends JsonBaseUrl {
    @Test
    public void postTest(){
        JsonPlaceHolderTodoData jphData = new JsonPlaceHolderTodoData();
        spec.pathParams("first","todos");
        Response response = given().spec(spec).contentType(ContentType.JSON).body(jphData.todoData()).when().post("/{first}");

        SoftAssert softAssert = new SoftAssert();
        JsonPath json = response.jsonPath();

        softAssert.assertEquals(201, response.getStatusCode());
        softAssert.assertEquals(jphData.todoData().get("userId"),json.getInt("userId"));
        softAssert.assertEquals(jphData.todoData().get("title"),json.getString("title"));
        softAssert.assertEquals(jphData.todoData().get("completed"),json.getBoolean("completed"));
        softAssert.assertAll();
    }
}
