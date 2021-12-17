/*
* File: sfo_43_total_number_of_1_in_integers_from_1_to_n_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_43_total_number_of_1_in_integers_from_1_to_n_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}

public class sfo_43_total_number_of_1_in_integers_from_1_to_n_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 12;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.countDigitOne(n);
        System.out.println(res);
    }
}
