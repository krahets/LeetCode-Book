/*
* File: lc_3_longest_substring_without_repeating_characters_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_3_longest_substring_without_repeating_characters;

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

public class lc_3_longest_substring_without_repeating_characters_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.lengthOfLongestSubstring(test_input);
        System.out.println(result);

    }
}
