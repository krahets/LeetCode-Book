/*
* File: sfo_15_number_of_1_bits_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_15_number_of_1_bits_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}

public class sfo_15_number_of_1_bits_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 11;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.hammingWeight(n);
        System.out.println(res);
    }
}
