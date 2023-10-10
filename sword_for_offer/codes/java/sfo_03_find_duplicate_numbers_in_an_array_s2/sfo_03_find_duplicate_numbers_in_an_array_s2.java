/*
* File: sfo_03_find_duplicate_numbers_in_an_array_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_03_find_duplicate_numbers_in_an_array_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}

public class sfo_03_find_duplicate_numbers_in_an_array_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 2, 3, 1, 0, 2, 5, 3 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.findRepeatNumber(nums);
        System.out.println(res);
    }
}
