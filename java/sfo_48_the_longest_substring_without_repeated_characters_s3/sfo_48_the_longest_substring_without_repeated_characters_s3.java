/*
* File: sfo_48_the_longest_substring_without_repeated_characters_s3.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_48_the_longest_substring_without_repeated_characters_s3;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}

public class sfo_48_the_longest_substring_without_repeated_characters_s3 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "abcabcbb";
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
