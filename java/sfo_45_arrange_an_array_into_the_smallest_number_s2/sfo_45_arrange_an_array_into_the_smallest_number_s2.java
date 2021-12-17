/*
* File: sfo_45_arrange_an_array_into_the_smallest_number_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_45_arrange_an_array_into_the_smallest_number_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}

public class sfo_45_arrange_an_array_into_the_smallest_number_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 3, 30, 34, 5, 9 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        String res = slt.minNumber(nums);
        System.out.println(res);
    }
}
