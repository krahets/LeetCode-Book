/*
* File: sfo_45_arrange_an_array_into_the_smallest_number_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_45_arrange_an_array_into_the_smallest_number_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}

public class sfo_45_arrange_an_array_into_the_smallest_number_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 3, 30, 34, 5, 9 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        String res = slt.minNumber(nums);
        System.out.println(res);
    }
}
