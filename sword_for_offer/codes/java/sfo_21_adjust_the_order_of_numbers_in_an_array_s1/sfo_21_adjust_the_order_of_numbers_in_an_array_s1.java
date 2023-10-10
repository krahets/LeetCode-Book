/*
* File: sfo_21_adjust_the_order_of_numbers_in_an_array_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_21_adjust_the_order_of_numbers_in_an_array_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}

public class sfo_21_adjust_the_order_of_numbers_in_an_array_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 1, 2, 3, 4 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.exchange(nums);
        System.out.println(Arrays.toString(res));
    }
}
