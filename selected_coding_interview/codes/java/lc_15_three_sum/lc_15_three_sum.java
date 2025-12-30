/*
* File: lc_15_three_sum.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_15_three_sum;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for(int k = 0; k < nums.length - 2; k++){
                if(nums[k] > 0) break;
                if(k > 0 && nums[k] == nums[k - 1]) continue;
                int i = k + 1, j = nums.length - 1;
                while(i < j){
                    int sum = nums[k] + nums[i] + nums[j];
                    if(sum < 0){
                        while(i < j && nums[i] == nums[++i]);
                    } else if (sum > 0) {
                        while(i < j && nums[j] == nums[--j]);
                    } else {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                        while(i < j && nums[i] == nums[++i]);
                        while(i < j && nums[j] == nums[--j]);
                    }
                }
            }
            return res;
        }
    }

public class lc_15_three_sum {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.threeSum(test_input);
        System.out.println(result);

    }
}
