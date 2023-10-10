/*
* File: sfo_42_largest_sum_contiguous_subarray_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_42_largest_sum_contiguous_subarray_s1;

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

public class sfo_42_largest_sum_contiguous_subarray_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.maxSubArray(nums);
        System.out.println(res);
    }
}
