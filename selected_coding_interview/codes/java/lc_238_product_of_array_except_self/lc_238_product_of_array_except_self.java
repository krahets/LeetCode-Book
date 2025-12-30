/*
* File: lc_238_product_of_array_except_self.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_238_product_of_array_except_self;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            if (len == 0) return new int[0];
            int[] ans = new int[len];
            ans[0] = 1;
            int tmp = 1;
            for (int i = 1; i < len; i++) {
                ans[i] = ans[i - 1] * nums[i - 1];
            }
            for (int i = len - 2; i >= 0; i--) {
                tmp *= nums[i + 1];
                ans[i] *= tmp;
            }
            return ans;
        }
    }

public class lc_238_product_of_array_except_self {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.productExceptSelf(test_input);
        System.out.println(result);

    }
}
