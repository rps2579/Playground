package main.playground;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playground {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        List<String> list = null;

        map.put("US", null);

        String s = (String) "value";

        boolean b = "value".equalsIgnoreCase(s);

        boolean b1 = Boolean.valueOf((String) map.get("US")) && b;
//        boolean b1 = ((boolean) map.getOrDefault("US", false)) && b;
        System.out.println(b1);
        boolean b2 = Boolean.valueOf((String) map.get("CA")) && b;
//        boolean b1 = ((boolean) map.getOrDefault("US", false)) && b;
        System.out.println(b2);

    }
}
