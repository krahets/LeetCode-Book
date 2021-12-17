/*
* File: sfo_58ii_left_rotation_of_a_string_s4.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_58ii_left_rotation_of_a_string_s4;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public String reverseLeftWords(String s, int n) {
        String res = "";
        for(int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for(int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }
}

public class sfo_58ii_left_rotation_of_a_string_s4 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "abcdefg";
        int n = 2;
        // ====== Driver Code ======
        Solution slt = new Solution();
        String res = slt.reverseLeftWords(s, n);
        System.out.println(res);
    }
}
