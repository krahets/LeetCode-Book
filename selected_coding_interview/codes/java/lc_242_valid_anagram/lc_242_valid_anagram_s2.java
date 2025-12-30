/*
* File: lc_242_valid_anagram_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_242_valid_anagram;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean isAnagram(String s, String t) {
            int len1 = s.length(), len2 = t.length();
            // 若 s, t 长度不同，则不互为重排
            if (len1 != len2)
                return false;
            // 初始化哈希表 dic
            HashMap<Character, Integer> dic = new HashMap<>();
            // 统计字符串 s 各字符数量，遇到 +1
            for (int i = 0; i < len1; i++) {
                // dic.getOrDefault(key, default) 函数：在 key 存在时返回对应 value ，在 key 不存在时默认返回 default 值；
                dic.put(s.charAt(i) , dic.getOrDefault(s.charAt(i), 0) + 1);
            }
            // 统计字符串 t 各字符数量，遇到 -1
            for (int i = 0; i < len2; i++) {
                dic.put(t.charAt(i) , dic.getOrDefault(t.charAt(i), 0) - 1);
            }
            // 遍历 s, t 中各字符的数量差
            for (int val : dic.values()) {
                // 若 s, t 中某字符的数量不一致，则不互为重排
                if (val != 0)
                    return false;
            }
            // 所有字符数量都一致，因此互为重排
            return true;
        }
    }

public class lc_242_valid_anagram_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String test_input_s = "anagram";
        String test_input_t = "nagaram";
        var expected_output = true;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.isAnagram(test_input_s, test_input_t);
        System.out.println(result);

    }
}
