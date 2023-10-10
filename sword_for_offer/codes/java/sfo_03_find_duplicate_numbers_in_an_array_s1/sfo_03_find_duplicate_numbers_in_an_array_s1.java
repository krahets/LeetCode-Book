/*
* File: sfo_03_find_duplicate_numbers_in_an_array_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_03_find_duplicate_numbers_in_an_array_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for(int num : nums) {
            if(dic.contains(num)) return num;
            dic.add(num);
        }
        return -1;
    }
}

public class sfo_03_find_duplicate_numbers_in_an_array_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 2, 3, 1, 0, 2, 5, 3 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.findRepeatNumber(nums);
        System.out.println(res);
    }
}
