/*
* File: lc_300_longest_increasing_subsequence_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_300_longest_increasing_subsequence;

import include.*;
import java.util.*;

// ===== Solution Code =====
    // Dynamic programming.
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            int res = 0;
            Arrays.fill(dp, 1);
            for(int i = 0; i < nums.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }

public class lc_300_longest_increasing_subsequence_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.lengthOfLIS(test_input);
        System.out.println(result);

    }
}
