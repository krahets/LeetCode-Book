/*
* File: lc_137_single_number_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_137_single_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int singleNumber(int[] nums) {
            int[] counts = new int[32];
            for(int num : nums) {
                for(int j = 0; j < 32; j++) {
                    counts[j] += num & 1;
                    num >>>= 1;
                }
            }
            int res = 0, m = 3;
            for(int i = 0; i < 32; i++) {
                res <<= 1;
                res |= counts[31 - i] % m;
            }
            return res;
        }
    }

public class lc_137_single_number_s2 {
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
