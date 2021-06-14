package ApiPractices;

import BaseUrls.DummyBaseUrl;
import BaseUrls.JsonBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest07 extends JsonBaseUrl {
    @Test
    public void getTest(){
        spec.pathParams("first", "todos");
        Response response = given().
                                spec(spec).
                            when().
                                get("/{first}");
        JsonPath json = response.jsonPath();

//        assertTrue();

        List<Integer> idList = json.getList("findAll{it.id<20}.id");
        System.out.println(idList);

        List<String> titleList = json.getList("findAll{it.id<5}.title");
        System.out.println(titleList);
        assertTrue(titleList.contains("delectus aut autem" ));

        Map<String,Object> actualData = new HashMap<>();
        actualData.put("userId",1);
        actualData.put("id",1);
        actualData.put("title","delectus aut autem");
        actualData.put("completed",false);
        System.out.println(actualData);

        Map<String,Object> expectedData = response.as(HashMap.class);
        System.out.println(expectedData);

//        assertEquals(expectedData.get("title"),actualData.get("title"));


    }
}
