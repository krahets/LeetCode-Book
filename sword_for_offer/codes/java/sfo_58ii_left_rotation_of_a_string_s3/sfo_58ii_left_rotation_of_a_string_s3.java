/*
* File: sfo_58ii_left_rotation_of_a_string_s3.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_58ii_left_rotation_of_a_string_s3;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }
}

public class sfo_58ii_left_rotation_of_a_string_s3 {
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
