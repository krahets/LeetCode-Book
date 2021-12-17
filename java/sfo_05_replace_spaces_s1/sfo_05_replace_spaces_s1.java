/*
* File: sfo_05_replace_spaces_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_05_replace_spaces_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}

public class sfo_05_replace_spaces_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "We are happy.";
        // ====== Driver Code ======
        Solution slt = new Solution();
        String res = slt.replaceSpace(s);
        System.out.println(res);
    }
}
