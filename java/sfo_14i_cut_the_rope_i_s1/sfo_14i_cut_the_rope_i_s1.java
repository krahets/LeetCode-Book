/*
* File: sfo_14i_cut_the_rope_i_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_14i_cut_the_rope_i_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}

public class sfo_14i_cut_the_rope_i_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 10;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.cuttingRope(n);
        System.out.println(res);
    }
}
