/*
* File: sfo_57_two_numbers_with_sum_s_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_57_two_numbers_with_sum_s_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }
}

public class sfo_57_two_numbers_with_sum_s_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
