/*
* File: lc_266_palindrome_permutation_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_266_palindrome_permutation;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean canPermutePalindrome(String s) {
            // 初始化哈希表
            HashMap<Character, Integer> dic = new HashMap<>();
            // 统计字符串中各字符的数量
            for (int i = 0; i < s.length(); i++) {
                dic.put(s.charAt(i), dic.getOrDefault(s.charAt(i), 0) + 1);
            }
            int odd = 0;
            for (int val : dic.values()) {
                // 统计“数量为奇数”字符的个数
                if (val % 2 == 1) {
                    // 若“数量为奇数”的字符个数 > 1 ，则不是回文串排列
                    if (++odd > 1) // 注意 ++odd > 1 是先执行 odd 自增，再执行逻辑判断； odd++ 的顺序反之
                        return false;
                }
            }
            // 若“数量为奇数”的字符个数 <= 1 ，则是回文串排列
            return true;
        }
    }

public class lc_266_palindrome_permutation_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.canPermutePalindrome(test_input);
        System.out.println(result);

    }
}
