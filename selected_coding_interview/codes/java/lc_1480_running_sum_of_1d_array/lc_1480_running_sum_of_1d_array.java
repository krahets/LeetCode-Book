/*
* File: lc_1480_running_sum_of_1d_array.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_1480_running_sum_of_1d_array;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int[] runningSum(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }
            return dp;
        }
    }

public class lc_1480_running_sum_of_1d_array {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.runningSum(test_input);
        System.out.println(result);

    }
}
