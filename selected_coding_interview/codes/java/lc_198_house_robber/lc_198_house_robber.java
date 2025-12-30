/*
* File: lc_198_house_robber.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_198_house_robber;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int rob(int[] nums) {
            int pre = 0, cur = 0, tmp;
            for(int num : nums) {
                tmp = cur;
                cur = Math.max(pre + num, cur);
                pre = tmp;
            }
            return cur;
        }
    }

public class lc_198_house_robber {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.rob(test_input);
        System.out.println(result);

    }
}
