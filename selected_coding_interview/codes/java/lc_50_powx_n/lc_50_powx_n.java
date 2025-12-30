/*
* File: lc_50_powx_n.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_50_powx_n;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public double myPow(double x, int n) {
            if(x == 0.0f) return 0.0d;
            long b = n;
            double res = 1.0;
            if(b < 0) {
                x = 1 / x;
                b = -b;
            }
            while(b > 0) {
                if((b & 1) == 1) res *= x;
                x *= x;
                b >>= 1;
            }
            return res;
        }
    }

public class lc_50_powx_n {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.myPow(...)
        // print(result)

    }
}
