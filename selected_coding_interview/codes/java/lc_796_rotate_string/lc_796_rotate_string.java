/*
* File: lc_796_rotate_string.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_796_rotate_string;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean rotateString(String s, String goal) {
            return s.length() == goal.length() && (goal + goal).contains(s);
        }
    }

public class lc_796_rotate_string {
    public static void main(String[] args) {
        // ======= Test Case =======
        String test_input_s = "abcde";
        String test_input_goal = "cdeab";
        var expected_output = true;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.rotateString(test_input_s, test_input_goal);
        System.out.println(result);

    }
}
