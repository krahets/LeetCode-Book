/*
* File: lc_233_number_of_digit_one_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_233_number_of_digit_one;

import include.*;
import java.util.*;

// ===== Solution Code =====
    int high = n / 10;
    int cur = n % 10;
    int low = 0;
    int digit = 1; // 个位

public class lc_233_number_of_digit_one_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int test_input = 12;
        int expected_output = 5;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.countDigitOne(test_input);
        System.out.println(result);

    }
}
