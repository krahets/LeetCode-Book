/*
* File: lc_154_find_minimum_in_rotated_sorted_array_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_154_find_minimum_in_rotated_sorted_array;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int findMin(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int m = (i + j) / 2;
                if (nums[m] > nums[j]) i = m + 1;
                else if (nums[m] < nums[j]) j = m;
                else {
                    int x = i;
                    for(int k = i + 1; k < j; k++) {
                        if(nums[k] < nums[x]) x = k;
                    }
                    return nums[x];
                }
            }
            return nums[i];
        }
    }

public class lc_154_find_minimum_in_rotated_sorted_array_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.findMin(test_input);
        System.out.println(result);

    }
}
