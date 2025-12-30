/*
* File: lc_394_decode_string_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_394_decode_string;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            LinkedList<Integer> stack_multi = new LinkedList<>();
            LinkedList<String> stack_res = new LinkedList<>();
            for(Character c : s.toCharArray()) {
                if(c == '[') {
                    stack_multi.addLast(multi);
                    stack_res.addLast(res.toString());
                    multi = 0;
                    res = new StringBuilder();
                }
                else if(c == ']') {
                    StringBuilder tmp = new StringBuilder();
                    int cur_multi = stack_multi.removeLast();
                    for(int i = 0; i < cur_multi; i++) tmp.append(res);
                    res = new StringBuilder(stack_res.removeLast() + tmp);
                }
                else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
                else res.append(c);
            }
            return res.toString();
        }
    }

public class lc_394_decode_string_s1 {
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
