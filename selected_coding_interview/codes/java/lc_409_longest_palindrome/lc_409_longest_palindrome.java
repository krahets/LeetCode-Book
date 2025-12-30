/*
* File: lc_409_longest_palindrome.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_409_longest_palindrome;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int longestPalindrome(String s) {
            // 统计各字符数量
            HashMap<Character, Integer> counter = new HashMap<>();
            for (int i = 0; i < s.length(); i++)
                counter.merge(s.charAt(i), 1, (a, b) -> a + b);
            // 统计构造回文串的最大长度
            int res = 0, odd = 0;
            for (Map.Entry<Character, Integer> kv : counter.entrySet()) {
                // 将当前字符出现次数向下取偶数，并计入 res
                int count = kv.getValue();
                int rem = count % 2;
                res += count - rem;
                // 若当前字符出现次数为奇数，则将 odd 置 1
                if (rem == 1) odd = 1;
            }
            return res + odd;
        }
    }

public class lc_409_longest_palindrome {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.longestPalindrome(test_input);
        System.out.println(result);

    }
}
