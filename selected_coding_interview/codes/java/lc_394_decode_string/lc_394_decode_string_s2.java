/*
* File: lc_394_decode_string_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_394_decode_string;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public String decodeString(String s) {
            return dfs(s, 0)[0];
        }
        private String[] dfs(String s, int i) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            while(i < s.length()) {
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9') 
                    multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i))); 
                else if(s.charAt(i) == '[') {
                    String[] tmp = dfs(s, i + 1);
                    i = Integer.parseInt(tmp[0]);
                    while(multi > 0) {
                        res.append(tmp[1]);
                        multi--;
                    }
                }
                else if(s.charAt(i) == ']') 
                    return new String[] { String.valueOf(i), res.toString() };
                else 
                    res.append(String.valueOf(s.charAt(i)));
                i++;
            }
            return new String[] { res.toString() };
        } 
    }

public class lc_394_decode_string_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.decodeString(test_input);
        System.out.println(result);

    }
}
