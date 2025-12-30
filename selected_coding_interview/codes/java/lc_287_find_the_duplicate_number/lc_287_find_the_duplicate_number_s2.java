/*
* File: lc_287_find_the_duplicate_number_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_287_find_the_duplicate_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int findDuplicate(int[] nums) {
            int i = 0;
            while(i < nums.length) {
                if(nums[i] == i) {
                    i++;
                    continue;
                }
                if(nums[nums[i]] == nums[i]) return nums[i];
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            return -1;
        }
    }

public class lc_287_find_the_duplicate_number_s2 {
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
