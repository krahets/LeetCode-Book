/*
* File: sfo_49_ugly_numbers_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_49_ugly_numbers_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}

public class sfo_49_ugly_numbers_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 10;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.nthUglyNumber(n);
        System.out.println(res);
    }
}
