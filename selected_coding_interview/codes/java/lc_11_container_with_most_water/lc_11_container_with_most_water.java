/*
* File: lc_11_container_with_most_water.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_11_container_with_most_water;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1, res = 0;
            while(i < j) {
                res = height[i] < height[j] ? 
                    Math.max(res, (j - i) * height[i++]): 
                    Math.max(res, (j - i) * height[j--]); 
            }
            return res;
        }
    }

public class lc_11_container_with_most_water {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.maxArea(test_input);
        System.out.println(result);

    }
}
