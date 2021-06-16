package test_data;

import java.util.HashMap;
import java.util.Map;

public class OpenWeatherMapTestData {

    public Map<String,Float> coordSetUp(){
        Map<String,Float> coord = new HashMap<>();
        coord.put("lon",-0.1257f);
        coord.put("lat",51.5085f);
        return coord;
    }

    public Map<String,Object> weatherSetup(){
        Map<String,Object> weather = new HashMap<>();
        weather.put("id",804);
        weather.put("main","Clouds");
        weather.put("description","overcast clouds");
        weather.put("icon","04n");
        return weather;
    }
}
