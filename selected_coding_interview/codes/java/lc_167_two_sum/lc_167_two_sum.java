/*
* File: lc_167_two_sum.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_167_two_sum;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                int s = numbers[i] + numbers[j];
                if (s < target) i++;
                else if (s > target) j--;
                else return new int[] { i + 1, j + 1 };
            }
            return new int[0];
        }
    }

public class lc_167_two_sum {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] test_input_numbers = new int[]{2, 7, 11, 15};
        int test_input_target = 9;
        int[] expected_output = new int[]{1, 2};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.twoSum(test_input_numbers, test_input_target);
        System.out.println(result);

    }
}
