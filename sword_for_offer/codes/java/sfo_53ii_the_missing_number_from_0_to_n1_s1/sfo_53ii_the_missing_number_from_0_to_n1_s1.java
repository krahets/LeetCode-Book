/*
* File: sfo_53ii_the_missing_number_from_0_to_n1_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_53ii_the_missing_number_from_0_to_n1_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}

public class sfo_53ii_the_missing_number_from_0_to_n1_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 0, 1, 3 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.missingNumber(nums);
        System.out.println(res);
    }
}
