/*
* File: lc_8_string_to_integer_atoi_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_8_string_to_integer_atoi;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int myAtoi(String s) {
            int res = 0, bndry = Integer.MAX_VALUE / 10;
            int i = 0, sign = 1, length = s.length();
            if(length == 0) return 0;
            while(s.charAt(i) == ' ')
                if(++i == length) return 0;
            if(s.charAt(i) == '-') sign = -1;
            if(s.charAt(i) == '-' || s.charAt(i) == '+') i++;
            for(int j = i; j < length; j++) {
                if(s.charAt(j) < '0' || s.charAt(j) > '9') break;
                if(res > bndry || res == bndry && s.charAt(j) > '7')
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                res = res * 10 + (s.charAt(j) - '0');
            }
            return sign * res;
        }
    }

public class lc_8_string_to_integer_atoi_s2 {
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
