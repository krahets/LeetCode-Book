/*
* File: sfo_53i_find_a_number_in_a_sorted_array_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_53i_find_a_number_in_a_sorted_array_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}

public class sfo_53i_find_a_number_in_a_sorted_array_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.search(nums, target);
        System.out.println(res);
    }
}
