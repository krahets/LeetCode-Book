/*
* File: lc_242_valid_anagram_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_242_valid_anagram;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean isAnagram(String s, String t) {
            int len1 = s.length(), len2 = t.length();
            if (len1 != len2)
                return false;
            HashMap<Character, Integer> dic = new HashMap<>();
            for (int i = 0; i < len1; i++) {
                dic.put(s.charAt(i) , dic.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < len2; i++) {
                dic.put(t.charAt(i) , dic.getOrDefault(t.charAt(i), 0) - 1);
            }
            for (int val : dic.values()) {
                if (val != 0)
                    return false;
            }
            return true;
        }
    }

public class lc_242_valid_anagram_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String test_input_s = "anagram";
        String test_input_t = "nagaram";
        var expected_output = true;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.isAnagram(test_input_s, test_input_t);
        System.out.println(result);

    }
}
