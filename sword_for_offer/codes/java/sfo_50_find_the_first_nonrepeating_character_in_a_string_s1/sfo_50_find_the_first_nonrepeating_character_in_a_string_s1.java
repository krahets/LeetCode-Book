/*
* File: sfo_50_find_the_first_nonrepeating_character_in_a_string_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_50_find_the_first_nonrepeating_character_in_a_string_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }
}

public class sfo_50_find_the_first_nonrepeating_character_in_a_string_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "abaccdeff";
        // ====== Driver Code ======
        Solution slt = new Solution();
        char res = slt.firstUniqChar(s);
        System.out.println(res);
    }
}
