/*
* File: lc_287_find_the_duplicate_number_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_287_find_the_duplicate_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int findDuplicate(int[] nums) {
            Set<Integer> hmap = new HashSet<>();
            for(int num : nums) {
                if(hmap.contains(num)) return num;
                hmap.add(num);
            }
            return -1;
        }
    }

public class lc_287_find_the_duplicate_number_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.findDuplicate(test_input);
        System.out.println(result);

    }
}
