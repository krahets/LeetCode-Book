/*
* File: sfo_60_probabilities_for_rolling_n_dices_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_60_probabilities_for_rolling_n_dices_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}

public class sfo_60_probabilities_for_rolling_n_dices_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 2;
        // ====== Driver Code ======
        Solution slt = new Solution();
        double[] res = slt.dicesProbability(n);
        System.out.println(Arrays.toString(res));
    }
}
