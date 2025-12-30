/*
* File: lc_392_is_subsequence.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_392_is_subsequence;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) return true;
            for (int i = 0, j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    // 若已经遍历完 s ，则提前返回 true
                    if (++i == s.length())
                        return true;
                }
            }
            return false;
        }
    }

public class lc_392_is_subsequence {
    public static void main(String[] args) {
        // ======= Test Case =======
        String test_input_s = "abc";
        String test_input_t = "ahbgdc";
        var expected_output = true;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.isSubsequence(test_input_s, test_input_t);
        System.out.println(result);

    }
}
