/*
* File: lc_266_palindrome_permutation_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_266_palindrome_permutation;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean canPermutePalindrome(String s) {
            HashMap<Character, Integer> dic = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                dic.put(s.charAt(i), dic.getOrDefault(s.charAt(i), 0) + 1);
            }
            int odd = 0;
            for (int val : dic.values()) {
                if (val % 2 == 1) {
                    if (++odd > 1)
                        return false;
                }
            }
            return true;
        }
    }

public class lc_266_palindrome_permutation_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.canPermutePalindrome(test_input);
        System.out.println(result);

    }
}
