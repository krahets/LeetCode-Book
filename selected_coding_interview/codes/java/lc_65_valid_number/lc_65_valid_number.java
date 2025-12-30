/*
* File: lc_65_valid_number.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_65_valid_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean isNumber(String s) {
            Map[] states = {
                new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<>() {{ put('d', 3); }},                                        // 4.
                new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<>() {{ put('d', 7); }},                                        // 6.
                new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<>() {{ put(' ', 8); }}                                         // 8.
            };
            int p = 0;
            char t;
            for(char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') t = 'd';
                else if (c == '+' || c == '-') t = 's';
                else if (c == 'e' || c == 'E') t = 'e';
                else if (c == '.' || c == ' ') t = c;
                else t = '?';
                if (!states[p].containsKey(t)) return false;
                p = (int)states[p].get(t);
            }
            return p == 2 || p == 3 || p == 7 || p == 8;
        }
    }

public class lc_65_valid_number {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.isNumber(test_input);
        System.out.println(result);

    }
}
