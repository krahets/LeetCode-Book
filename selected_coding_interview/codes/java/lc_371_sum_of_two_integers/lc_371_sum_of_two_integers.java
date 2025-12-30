/*
* File: lc_371_sum_of_two_integers.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_371_sum_of_two_integers;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int getSum(int a, int b) {
            // 循环，当进位为 0 时跳出
            while (b != 0) {
                int c = (a & b) << 1;  // c = 进位
                a ^= b; // a = 非进位和
                b = c; // b = 进位
            }
            return a;
        }
    }

public class lc_371_sum_of_two_integers {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.getSum(...)
        // print(result)

    }
}
