package pojo_tests;

import base_urls.HerokuBaseUrl;
import org.junit.Test;

public class PostRequestWithPojo02 extends HerokuBaseUrl {
    @Test
    public void postTest(){
        spec.pathParams("first","booking");

    }
}
