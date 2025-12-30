/*
* File: lc_169_majority_element_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_169_majority_element;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int majorityElement(int[] nums) {
            int x = 0, votes = 0, count = 0;
            for (int num : nums){
                if (votes == 0) x = num;
                votes += num == x ? 1 : -1;
            }
            // 验证 x 是否为众数
            for (int num : nums)
                if (num == x) count++;
            return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
        }
    }

public class lc_169_majority_element_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.majorityElement(test_input);
        System.out.println(result);

    }
}
