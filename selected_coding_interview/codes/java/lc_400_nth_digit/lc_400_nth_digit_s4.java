/*
* File: lc_400_nth_digit_s4.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_400_nth_digit;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int findNthDigit(int n) {
            int digit = 1;
            long start = 1;
            long count = 9;
            while (n > count) { // 1.
                n -= count;
                start *= 10;
                digit += 1;
                count = digit * start * 9;
            }
            long num = start + (n - 1) / digit; // 2.
            return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
        }
    }

public class lc_400_nth_digit_s4 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int test_input = 11;
        int expected_output = 0;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.findNthDigit(test_input);
        System.out.println(result);

    }
}
