/*
* File: lc_137_single_number_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_137_single_number;

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

public class lc_137_single_number_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.singleNumber(test_input);
        System.out.println(result);

    }
}
