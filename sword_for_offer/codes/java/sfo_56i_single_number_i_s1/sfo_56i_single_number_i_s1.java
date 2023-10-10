/*
* File: sfo_56i_single_number_i_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_56i_single_number_i_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums)               // 1. 遍历异或
            n ^= num;
        while((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        for(int num: nums) {              // 3. 遍历 nums 分组
            if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        return new int[] {x, y};          // 5. 返回出现一次的数字
    }
}

public class sfo_56i_single_number_i_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 4, 1, 4, 6 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.singleNumbers(nums);
        System.out.println(Arrays.toString(res));
    }
}
