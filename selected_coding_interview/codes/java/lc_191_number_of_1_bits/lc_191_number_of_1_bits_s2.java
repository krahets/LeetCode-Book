/*
* File: lc_191_number_of_1_bits_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_191_number_of_1_bits;

import include.*;
import java.util.*;

// ===== Solution Code =====
    public class Solution {
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                res++;
                n &= n - 1;
            }
            return res;
        }
    }

public class lc_191_number_of_1_bits_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.hammingWeight(...)
        // print(result)

    }
}
