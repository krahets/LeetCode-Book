/*
* File: sfo_64_solve_1_2___n_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_64_solve_1_2___n_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}

public class sfo_64_solve_1_2___n_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 3;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.sumNums(n);
        System.out.println(res);
    }
}
