/*
* File: sfo_56ii_single_number_ii_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_56ii_single_number_ii_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                counts[i] += num & 1; // 更新第 i 位 1 的个数之和
                num >>= 1;            // 第 i 位 --> 第 i 位
            }
        }
        int res = 0, m = 3;
        for(int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= counts[i] % m;     // 恢复第 i 位
        }
        return res;
    }
}

public class sfo_56ii_single_number_ii_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 3, 4, 3, 3 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.singleNumber(nums);
        System.out.println(res);
    }
}
