/*
* File: lc_215_kth_largest_element_in_an_array_s2.java
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
        private int quickSort(int[] nums, int k, int l, int r) {
            int i = l, j = r;
            while (i < j) {
                while (i < j && nums[j] >= nums[l]) j--;
                while (i < j && nums[i] <= nums[l]) i++;
                swap(nums, i, j);
            }
            swap(nums, i, l);
            if (i > nums.length - k) return quickSort(nums, k, l, i - 1);
            if (i < nums.length - k) return quickSort(nums, k, i + 1, r);
            // 若基准数索引为 n - k ，则直接返回该元素
            return nums[nums.length - k];
        }
        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, k, 0, nums.length - 1);
        }
    }

public class lc_215_kth_largest_element_in_an_array_s2 {
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
