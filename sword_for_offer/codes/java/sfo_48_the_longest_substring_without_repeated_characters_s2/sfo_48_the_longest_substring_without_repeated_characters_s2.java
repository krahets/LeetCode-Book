/*
* File: sfo_48_the_longest_substring_without_repeated_characters_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_48_the_longest_substring_without_repeated_characters_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, tmp = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            int i = j - 1;
            while(i >= 0 && s.charAt(i) != s.charAt(j)) i--; // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}

public class sfo_48_the_longest_substring_without_repeated_characters_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "abcabcbb";
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
