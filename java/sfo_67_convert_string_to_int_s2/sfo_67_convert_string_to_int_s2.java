/*
* File: sfo_67_convert_string_to_int_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_67_convert_string_to_int_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int strToInt(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if(length == 0) return 0;
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }
}

public class sfo_67_convert_string_to_int_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String str = "42";
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.strToInt(str);
        System.out.println(res);
    }
}
