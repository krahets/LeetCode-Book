/*
* File: lc_233_number_of_digit_one_s3.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_233_number_of_digit_one;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int countDigitOne(int n) {
            int digit = 1, res = 0;
            int high = n / 10, cur = n % 10, low = 0;
            while (high != 0 || cur != 0) {
                if (cur == 0) res += high * digit;
                else if (cur == 1) res += high * digit + low + 1;
                else res += (high + 1) * digit;
                low += cur * digit;
                cur = high % 10;
                high /= 10;
                digit *= 10;
            }
            return res;
        }
    }

public class lc_233_number_of_digit_one_s3 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.countDigitOne(...)
        // print(result)

    }
}
