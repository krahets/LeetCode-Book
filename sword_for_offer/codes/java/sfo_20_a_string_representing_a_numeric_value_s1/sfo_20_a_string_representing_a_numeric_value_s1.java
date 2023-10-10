/*
* File: sfo_20_a_string_representing_a_numeric_value_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_20_a_string_representing_a_numeric_value_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public boolean isNumber(String s) {
        HashMap[] states = {
            new HashMap<Character, Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
            new HashMap<Character, Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
            new HashMap<Character, Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
            new HashMap<Character, Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
            new HashMap<Character, Integer>() {{ put('d', 3); }},                                        // 4.
            new HashMap<Character, Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.
            new HashMap<Character, Integer>() {{ put('d', 7); }},                                        // 6.
            new HashMap<Character, Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.
            new HashMap<Character, Integer>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}

public class sfo_20_a_string_representing_a_numeric_value_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "    .1  ";
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.isNumber(s);
        System.out.println(res);
    }
}
