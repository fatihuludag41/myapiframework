package utils;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    public static <T> T convertJsonToJava(String json, Class<T> cls){
        T javaResult = null;

        try {
            javaResult = mapper.readValue(json, cls);
        } catch (IOException e) {
            System.out.println("Json could not be converted to Java Object: " + e.getMessage());
        }
        return javaResult;
    }


    public static String convertJavaToJson(Object obj){
        String jsonResult = null;

        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            System.out.println("Java could not be converted to Json Object: " + e.getMessage());
        }
        return jsonResult;
    }
}
