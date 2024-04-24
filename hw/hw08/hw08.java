package hw.hw08;

import java.util.HashMap;
import java.util.Map;

public class hw08 {
    public static int longestPalindrome(String s) {
        int longestLength = 0;
        int remainder = 0;
        Map<Character, Integer> hash = new HashMap<>();

        for (char x : s.toCharArray()) {
            hash.put(x, hash.getOrDefault(x, 0) + 1);
        }

        for (char x : hash.keySet()) {
            if (hash.get(x) > 1) {
                if (hash.get(x) % 2 == 0) {
                    longestLength += hash.get(x);
                } else {
                    remainder = 1;
                    longestLength += hash.get(x) - 1;
                }
            } else {
                remainder = 1;
            }
        }
        return longestLength + remainder;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s)); // Output: 7
    }
}
