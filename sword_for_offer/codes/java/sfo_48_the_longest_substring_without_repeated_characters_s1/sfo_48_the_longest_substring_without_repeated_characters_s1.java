/*
* File: sfo_48_the_longest_substring_without_repeated_characters_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_48_the_longest_substring_without_repeated_characters_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}

public class sfo_48_the_longest_substring_without_repeated_characters_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "abcabcbb";
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
