/*
* File: sfo_59i_sliding_window_maximum_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_59i_sliding_window_maximum_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }
}

public class sfo_59i_sliding_window_maximum_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
