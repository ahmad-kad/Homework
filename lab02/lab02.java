package lab02;

import java.util.HashMap;
import java.util.Map;

public class lab02 {
    
    public static Map<Character, Integer> createHashMap(String input) {
        Map<Character, Integer> hashmap = new HashMap<>();
        for (char x : input.toCharArray()) {
            hashmap.put(x, hashmap.getOrDefault(x, 0) + 1);
        }
        return hashmap;
    }

    public static boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = createHashMap(s);
        Map<Character, Integer> tMap = createHashMap(t);
        return sMap.equals(tMap);
    }

    public static void main(String[] args) {
        String[][] testCases = {
            {"listen", "silent"},
            {"hello", "hello"},
            {"earth", "hearted"},
            {"Tea", "eAt"},
            {"debit card", "bad credit"},
            {"astronomer", "moon starer"},
            {"Café", "éaFc"},
            {"", ""},
            {"a", "a"},
            {"hello", "world"}
        };

        String GREEN = "\u001B[92m";
        String RED = "\u001B[91m";
        String RESET = "\u001B[0m";

        for (int idx = 0; idx < testCases.length; idx++) {
            String str1 = testCases[idx][0];
            String str2 = testCases[idx][1];
            boolean result = anagram(str1, str2);
            String color = result ? GREEN : RED;
            System.out.printf("Test Case %d: %s%s%s : '%s' and '%s'\n", idx + 1, color, result, RESET, str1, str2);
        }
    }
}
