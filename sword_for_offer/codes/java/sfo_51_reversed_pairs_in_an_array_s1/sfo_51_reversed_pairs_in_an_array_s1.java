/*
* File: sfo_51_reversed_pairs_in_an_array_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_51_reversed_pairs_in_an_array_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    int[] nums, tmp;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }
    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}

public class sfo_51_reversed_pairs_in_an_array_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 7, 5, 6, 4 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.reversePairs(nums);
        System.out.println(res);
    }
}
