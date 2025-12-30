/*
* File: lc_151_reverse_words_in_a_string_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_151_reverse_words_in_a_string;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public String reverseWords(String s) {
            String[] strs = s.trim().split(" ");        // 删除首尾空格，分割字符串
            StringBuilder res = new StringBuilder();
            for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
                if (strs[i].equals("")) continue;        // 遇到空单词则跳过
                res.append(strs[i] + " ");              // 将单词拼接至 StringBuilder
            }
            return res.toString().trim();               // 转化为字符串，删除尾部空格，并返回
        }
    }

public class lc_151_reverse_words_in_a_string_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.reverseWords(test_input);
        System.out.println(result);

    }
}
