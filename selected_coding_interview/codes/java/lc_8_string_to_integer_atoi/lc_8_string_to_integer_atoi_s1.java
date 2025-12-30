/*
* File: lc_8_string_to_integer_atoi_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_8_string_to_integer_atoi;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int myAtoi(String s) {
            char[] c = s.trim().toCharArray();
            if (c.length == 0) return 0;
            int res = 0, bndry = Integer.MAX_VALUE / 10;
            int i = 1, sign = 1;
            if (c[0] == '-') sign = -1;
            else if (c[0] != '+') i = 0;
            for (int j = i; j < c.length; j++) {
                if (c[j] < '0' || c[j] > '9') break;
                if (res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                res = res * 10 + (c[j] - '0');
            }
            return sign * res;
        }
    }

public class lc_8_string_to_integer_atoi_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.myAtoi(test_input);
        System.out.println(result);

    }
}
