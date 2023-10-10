/*
* File: sfo_63_the_maximum_profit_of_stocks_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_63_the_maximum_profit_of_stocks_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}

public class sfo_63_the_maximum_profit_of_stocks_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.maxProfit(prices);
        System.out.println(res);
    }
}
