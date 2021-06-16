package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTodoData {
    public Map<String,Object> todoData(){
        Map<String,Object> data = new HashMap<>();
        data.put("userId",3);
        data.put("title","erdemli geceler");
        data.put("completed",true);
        return data;
    }
}
