/*
* File: lc_239_sliding_window_maximum_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_239_sliding_window_maximum;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length == 0 || k == 0) return new int[0];
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            // 未形成窗口
            for(int i = 0; i < k; i++) {
                while(!deque.isEmpty() && deque.peekLast() < nums[i])
                    deque.removeLast();
                deque.addLast(nums[i]);
            }
            res[0] = deque.peekFirst();
            // 形成窗口后
            for(int i = k; i < nums.length; i++) {
                if(deque.peekFirst() == nums[i - k])
                    deque.removeFirst();
                while(!deque.isEmpty() && deque.peekLast() < nums[i])
                    deque.removeLast();
                deque.addLast(nums[i]);
                res[i - k + 1] = deque.peekFirst();
            }
            return res;
        }
    }

public class lc_239_sliding_window_maximum_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] test_input_nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int test_input_k = 3;
        int[] expected_output = new int[]{3, 3, 5, 5, 6, 7};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.maxSlidingWindow(test_input_nums, test_input_k);
        System.out.println(result);

    }
}
