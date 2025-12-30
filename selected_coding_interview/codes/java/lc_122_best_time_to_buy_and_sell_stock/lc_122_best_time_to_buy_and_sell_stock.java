/*
* File: lc_122_best_time_to_buy_and_sell_stock.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_122_best_time_to_buy_and_sell_stock;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                int tmp = prices[i] - prices[i - 1];
                if (tmp > 0) profit += tmp;
            }
            return profit;
        }
    }

public class lc_122_best_time_to_buy_and_sell_stock {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.maxProfit(test_input);
        System.out.println(result);

    }
}
