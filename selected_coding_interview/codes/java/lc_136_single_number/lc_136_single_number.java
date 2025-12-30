/*
* File: lc_136_single_number.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_136_single_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int singleNumber(int[] nums) {
            int x = 0;
            for (int num : nums)  // 1. 遍历 nums 执行异或运算
                x ^= num;
            return x;            // 2. 返回出现一次的数字 x
        }
    }

public class lc_136_single_number {
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
