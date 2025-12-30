/*
* File: lc_53_maximum_subarray.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_53_maximum_subarray;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            for(int i = 1; i < nums.length; i++) {
                nums[i] += Math.max(nums[i - 1], 0);
                res = Math.max(res, nums[i]);
            }
            return res;
        }
    }

public class lc_53_maximum_subarray {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.maxSubArray(test_input);
        System.out.println(result);

    }
}
