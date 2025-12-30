/*
* File: lc_231_power_of_two.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_231_power_of_two;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }

public class lc_231_power_of_two {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.isPowerOfTwo(...)
        // print(result)

    }
}
