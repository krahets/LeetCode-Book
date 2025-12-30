/*
* File: lc_300_longest_increasing_subsequence_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_300_longest_increasing_subsequence;

import include.*;
import java.util.*;

// ===== Solution Code =====
    // Dynamic programming + Dichotomy.
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int res = 0;
            for(int num : nums) {
                int i = 0, j = res;
                while(i < j) {
                    int m = (i + j) / 2;
                    if(tails[m] < num) i = m + 1;
                    else j = m;
                }
                tails[i] = num;
                if(res == j) res++;
            }
            return res;
        }
    }

public class lc_300_longest_increasing_subsequence_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.lengthOfLIS(test_input);
        System.out.println(result);

    }
}
