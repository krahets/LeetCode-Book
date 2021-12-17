/*
* File: sfo_59i_sliding_window_maximum_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_59i_sliding_window_maximum_s2;

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

public class sfo_59i_sliding_window_maximum_s2 {
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
