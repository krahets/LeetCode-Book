/*
* File: sfo_61_straight_in_poker_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_61_straight_in_poker_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}

public class sfo_61_straight_in_poker_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 0, 0, 1, 2, 5 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.isStraight(nums);
        System.out.println(res);
    }
}
