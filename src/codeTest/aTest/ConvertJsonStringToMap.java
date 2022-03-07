package codeTest.aTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConvertJsonStringToMap {
    public static void main(String[] args) {
        String jsonLine = "{\"name\":\"riley\", \"age\": 25,\"title\":\"sdet\",\"company\":\"finra\"}";
        Map<String, String> map = convert(jsonLine);
        System.out.println(map);
    }
    public static Map<String, String> convert(String inputJson){
        if(inputJson == null || inputJson.length() < 1){
            return null;
        }

        Map<String, String> map = new HashMap<>();

        String[] strs = inputJson.split(",");
        for(String str : strs){
            String[] pairs = str.split(":");
            map.put(pairs[0], pairs[1]);
        }
        System.out.println(Arrays.toString(strs));


        return map;

    }
}
