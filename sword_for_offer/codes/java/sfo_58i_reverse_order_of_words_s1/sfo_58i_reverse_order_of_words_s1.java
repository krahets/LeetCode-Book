/*
* File: sfo_58i_reverse_order_of_words_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_58i_reverse_order_of_words_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public String reverseWords(String s) {
        s = s.trim();                                    // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;     // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--;     // 跳过单词间空格
            j = i;                                       // j 指向下个单词的尾字符
        }
        return res.toString().trim();                    // 转化为字符串并返回
    }
}

public class sfo_58i_reverse_order_of_words_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "the sky is blue";
        // ====== Driver Code ======
        Solution slt = new Solution();
        String res = slt.reverseWords(s);
        System.out.println(res);
    }
}
