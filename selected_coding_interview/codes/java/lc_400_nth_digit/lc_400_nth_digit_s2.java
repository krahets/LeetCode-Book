/*
* File: lc_400_nth_digit_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_400_nth_digit;

import include.*;
import java.util.*;

// ===== Solution Code =====
    long num = start + (n - 1) / digit;

public class lc_400_nth_digit_s2 {
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
