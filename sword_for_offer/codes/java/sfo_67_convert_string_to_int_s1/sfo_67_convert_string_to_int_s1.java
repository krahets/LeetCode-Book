/*
* File: sfo_67_convert_string_to_int_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_67_convert_string_to_int_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}

public class sfo_67_convert_string_to_int_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String str = "42";
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.strToInt(str);
        System.out.println(res);
    }
}
