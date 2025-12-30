/*
* File: lc_121_best_time_to_buy_and_sell_stock.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_121_best_time_to_buy_and_sell_stock;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int maxProfit(int[] prices) {
            int cost = Integer.MAX_VALUE, profit = 0;
            for (int price : prices) {
                cost = Math.min(cost, price);
                profit = Math.max(profit, price - cost);
            }
            return profit;
        }
    }

public class lc_121_best_time_to_buy_and_sell_stock {
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
