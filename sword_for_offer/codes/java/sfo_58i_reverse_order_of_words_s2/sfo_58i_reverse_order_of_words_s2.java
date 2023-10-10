/*
* File: sfo_58i_reverse_order_of_words_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_58i_reverse_order_of_words_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");        // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue;        // 遇到空单词则跳过
            res.append(strs[i] + " ");              // 将单词拼接至 StringBuilder
        }
        return res.toString().trim();               // 转化为字符串，删除尾部空格，并返回
    }
}

public class sfo_58i_reverse_order_of_words_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "the sky is blue";
        // ====== Driver Code ======
        Solution slt = new Solution();
        String res = slt.reverseWords(s);
        System.out.println(res);
    }
}
