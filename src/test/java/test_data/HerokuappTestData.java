package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuappTestData {

    public Map<String,String> bookingDatesSetUp(){
        Map<String,String> dates = new HashMap<>();
        dates.put("checkin","2021-06-14");
        dates.put("checkout","2021-06-21");
        return dates;
    }

    public Map<String,Object> expectedDataSetUp(){
        Map<String,Object> expectedJson = new HashMap<>();
        expectedJson.put("firstname","Erdem");
        expectedJson.put("lastname","Ozturk");
        expectedJson.put("totalprice",500);
        expectedJson.put("depositpaid",false);
        expectedJson.put("bookingdates", bookingDatesSetUp());
        return expectedJson;
    }
}
