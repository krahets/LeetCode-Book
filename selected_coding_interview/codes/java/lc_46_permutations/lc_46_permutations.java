/*
* File: lc_46_permutations.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_46_permutations;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        List<Integer> nums;
        List<List<Integer>> res;
        void swap(int a, int b) {
            int tmp = nums.get(a);
            nums.set(a, nums.get(b));
            nums.set(b, tmp);
        }
        void dfs(int x) {
            if (x == nums.size() - 1) {
                res.add(new ArrayList<>(nums));  // 添加排列方案
                return;
            }
            for (int i = x; i < nums.size(); i++) {
                swap(i, x);              // 交换，将 nums[i] 固定在第 x 位
                dfs(x + 1);              // 开启固定第 x + 1 位元素
                swap(i, x);              // 恢复交换
            }
        }
        public List<List<Integer>> permute(int[] nums) {
            this.res = new ArrayList<>();
            this.nums = new ArrayList<>();
            for (int num : nums) {
                this.nums.add(num);
            }
            dfs(0);
            return res;
        }
    }

public class lc_46_permutations {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.permute(test_input);
        System.out.println(result);

    }
}
