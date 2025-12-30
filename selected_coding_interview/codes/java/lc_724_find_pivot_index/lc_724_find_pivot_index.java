/*
* File: lc_724_find_pivot_index.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_724_find_pivot_index;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int pivotIndex(int[] nums) {
            int sumLeft = 0, sumRight = Arrays.stream(nums).sum();
            for (int i = 0; i < nums.length; i++) {
                sumRight -= nums[i];
                // 若左侧元素和等于右侧元素和，返回中心下标 i
                if (sumLeft == sumRight)
                    return i;
                sumLeft += nums[i];
            }
            return -1;
        }
    }

public class lc_724_find_pivot_index {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.pivotIndex(test_input);
        System.out.println(result);

    }
}
