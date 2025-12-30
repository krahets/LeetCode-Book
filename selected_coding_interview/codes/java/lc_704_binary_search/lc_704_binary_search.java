/*
* File: lc_704_binary_search.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_704_binary_search;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int search(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            while (i <= j) {
                int m = (i + j) / 2;
                if (nums[m] < target) i = m + 1;
                else if (nums[m] > target) j = m - 1;
                else return m;
            }
            return -1;
        }
    }

public class lc_704_binary_search {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] test_input_nums = new int[]{-1, 0, 3, 5, 9, 12};
        int test_input_target = 9;
        int expected_output = 4;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.search(test_input_nums, test_input_target);
        System.out.println(result);

    }
}
