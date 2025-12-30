/*
* File: lc_400_nth_digit_s3.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_400_nth_digit;

import include.*;
import java.util.*;

// ===== Solution Code =====
    String s = Long.toString(num); // 转化为 string
    int res = s.charAt((n - 1) % digit) - '0'; // 获得 num 的 第 (n - 1) % digit 个数位，并转化为 int

public class lc_400_nth_digit_s3 {
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
