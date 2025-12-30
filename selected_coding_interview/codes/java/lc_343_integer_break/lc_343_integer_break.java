/*
* File: lc_343_integer_break.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_343_integer_break;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int integerBreak(int n) {
            if(n <= 3) return n - 1;
            int a = n / 3, b = n % 3;
            if(b == 0) return (int)Math.pow(3, a);
            if(b == 1) return (int)Math.pow(3, a - 1) * 4;
            return (int)Math.pow(3, a) * 2;
        }
    }

public class lc_343_integer_break {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.integerBreak(...)
        // print(result)

    }
}
