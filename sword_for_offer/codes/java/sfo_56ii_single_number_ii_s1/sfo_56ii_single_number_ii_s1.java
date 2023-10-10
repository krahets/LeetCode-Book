/*
* File: sfo_56ii_single_number_ii_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_56ii_single_number_ii_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}

public class sfo_56ii_single_number_ii_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 3, 4, 3, 3 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.singleNumber(nums);
        System.out.println(res);
    }
}
