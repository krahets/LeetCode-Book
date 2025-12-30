/*
* File: lc_264_ugly_number.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_264_ugly_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int nthUglyNumber(int n) {
            int a = 0, b = 0, c = 0;
            int[] res = new int[n];
            res[0] = 1;
            for(int i = 1; i < n; i++) {
                int n2 = res[a] * 2, n3 = res[b] * 3, n5 = res[c] * 5;
                res[i] = Math.min(Math.min(n2, n3), n5);
                if (res[i] == n2) a++;
                if (res[i] == n3) b++;
                if (res[i] == n5) c++;
            }
            return res[n - 1];
        }
    }

public class lc_264_ugly_number {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.nthUglyNumber(...)
        // print(result)

    }
}
