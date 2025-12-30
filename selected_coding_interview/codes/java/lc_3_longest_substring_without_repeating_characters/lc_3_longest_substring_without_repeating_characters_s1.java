/*
* File: lc_3_longest_substring_without_repeating_characters_s1.java
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
            int i = -1, res = 0, len = s.length();
            for(int j = 0; j < len; j++) {
                if (dic.containsKey(s.charAt(j)))
                    i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
                dic.put(s.charAt(j), j); // 哈希表记录
                res = Math.max(res, j - i); // 更新结果
            }
            return res;
        }
    }

public class lc_3_longest_substring_without_repeating_characters_s1 {
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
