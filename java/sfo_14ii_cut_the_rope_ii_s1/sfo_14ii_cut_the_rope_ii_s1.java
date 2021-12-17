/*
* File: sfo_14ii_cut_the_rope_ii_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_14ii_cut_the_rope_ii_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }
}

public class sfo_14ii_cut_the_rope_ii_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 10;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.cuttingRope(n);
        System.out.println(res);
    }
}
