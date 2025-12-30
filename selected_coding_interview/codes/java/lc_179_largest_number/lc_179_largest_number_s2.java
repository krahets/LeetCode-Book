/*
* File: lc_179_largest_number_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_179_largest_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        void quickSort(String[] strs, int l, int r) {
            if (l >= r) return;
            int i = l, j = r;
            String tmp = strs[i];
            while (i < j) {
                while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
                while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
                tmp = strs[i];
                strs[i] = strs[j];
                strs[j] = tmp;
            }
            strs[i] = strs[l];
            strs[l] = tmp;
            quickSort(strs, l, i - 1);
            quickSort(strs, i + 1, r);
        }
        public String largestNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            quickSort(strs, 0, strs.length - 1);
            StringBuilder res = new StringBuilder();
            if (strs[strs.length - 1].equals("0"))
                return "0";
            for(int i = strs.length - 1; i >=0; i--)
                res.append(strs[i]);
            return res.toString();
        }
    }

public class lc_179_largest_number_s2 {
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
