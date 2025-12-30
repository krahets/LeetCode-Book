/*
* File: lc_400_nth_digit_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_400_nth_digit;

import include.*;
import java.util.*;

// ===== Solution Code =====
    int digit = 1;
    long start = 1;
    long count = 9;
    while (n > count) {
       n -= count;
       start *= 10; // 1, 10, 100, ...
       digit += 1;  // 1,  2,  3, ...
       count = digit * start * 9; // 9, 180, 2700, ...
    }

public class lc_400_nth_digit_s1 {
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
