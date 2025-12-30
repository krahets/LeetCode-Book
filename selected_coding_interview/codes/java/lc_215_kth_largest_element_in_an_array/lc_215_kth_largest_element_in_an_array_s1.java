/*
* File: lc_215_kth_largest_element_in_an_array_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_215_kth_largest_element_in_an_array;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        private void quickSort(int[] nums, int l, int r) {
            // 子数组长度为 1 时终止递归
            if (l >= r) return;
            // 哨兵划分操作（以 nums[l] 作为基准数）
            int i = l, j = r;
            while (i < j) {
                while (i < j && nums[j] >= nums[l]) j--;
                while (i < j && nums[i] <= nums[l]) i++;
                swap(nums, i, j);
            }
            swap(nums, i, l);
            // 递归左（右）子数组执行哨兵划分
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
        public int findKthLargest(int[] nums, int k) {
            quickSort(nums, 0, nums.length - 1);
            return nums[nums.length - k];
        }
    }

public class lc_215_kth_largest_element_in_an_array_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] test_input_nums = new int[]{3, 2, 1, 5, 6, 4};
        int test_input_k = 2;
        int expected_output = 5;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.findKthLargest(test_input_nums, test_input_k);
        System.out.println(result);

    }
}
