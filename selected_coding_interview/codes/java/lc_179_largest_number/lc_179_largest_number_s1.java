/*
* File: lc_179_largest_number_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_179_largest_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public String largestNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
            if (strs[0].equals("0"))
                return "0";
            StringBuilder res = new StringBuilder();
            for (String s : strs)
                res.append(s);
            return res.toString();
        }
    }

public class lc_179_largest_number_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.largestNumber(test_input);
        System.out.println(result);

    }
}
