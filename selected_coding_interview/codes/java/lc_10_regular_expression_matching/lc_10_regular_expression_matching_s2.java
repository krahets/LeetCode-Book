/*
* File: lc_10_regular_expression_matching_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_10_regular_expression_matching;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length() + 1, n = p.length() + 1;
            boolean[][] dp = new boolean[m][n];
            dp[0][0] = true;
            // 初始化首行
            for(int j = 2; j < n; j += 2)
                dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
            // 状态转移
            for(int i = 1; i < m; i++) {
                for(int j = 1; j < n; j++) {
                    if (p.charAt(j - 1) == '*') {
                        if (dp[i][j - 2]) dp[i][j] = true;                                            // 1.
                        else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true; // 2.
                        else if (dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;             // 3.
                    } else {
                        if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;  // 1.
                        else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;         // 2.
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

public class lc_10_regular_expression_matching_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String test_input_s = "aa";
        String test_input_p = "a";
        var expected_output = false;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.isMatch(test_input_s, test_input_p);
        System.out.println(result);

    }
}
