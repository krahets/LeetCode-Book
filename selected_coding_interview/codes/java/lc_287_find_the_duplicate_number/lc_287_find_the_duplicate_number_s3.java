/*
* File: lc_287_find_the_duplicate_number_s3.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_287_find_the_duplicate_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    public class Solution {
        private int next(int[] nums, int index) {
            return nums[index];
        }
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;
            // 第一次相遇
            do {
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            } while (slow != fast);
            slow = 0;
            // 第二次相遇
            while (slow != fast) {
                slow = next(nums, slow);
                fast = next(nums, fast);
            }
            return slow;
        }
    }

public class lc_287_find_the_duplicate_number_s3 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] test_input = new int[]{1, 3, 4, 2, 2};
        int expected_output = 2;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.findDuplicate(test_input);
        System.out.println(result);

    }
}
