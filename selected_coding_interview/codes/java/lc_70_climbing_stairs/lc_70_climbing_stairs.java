/*
* File: lc_70_climbing_stairs.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_70_climbing_stairs;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int climbStairs(int n) {
            int a = 1, b = 1, sum;
            for(int i = 0; i < n - 1; i++){
                sum = a + b;
                a = b;
                b = sum;
            }
            return b;
        }
    }

public class lc_70_climbing_stairs {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.climbStairs(...)
        // print(result)

    }
}
