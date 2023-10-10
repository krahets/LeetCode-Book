/*
* File: sfo_58ii_left_rotation_of_a_string_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_58ii_left_rotation_of_a_string_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}

public class sfo_58ii_left_rotation_of_a_string_s1 {
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
