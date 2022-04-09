package map;

import java.util.Map;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {

        Map<String, String> cookies = new TreeMap<>();
        cookies.put("username", "Maria");
        cookies.put("email","email@email.com");
        cookies.put("phone", "9987125");
        cookies.remove("email");
        System.out.println(cookies.get("phone"));
    }
}
