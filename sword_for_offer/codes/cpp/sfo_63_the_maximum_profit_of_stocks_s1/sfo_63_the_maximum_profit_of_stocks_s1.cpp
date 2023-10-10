/*
* File: sfo_63_the_maximum_profit_of_stocks_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int cost = INT_MAX, profit = 0;
        for(int price : prices) {
            cost = min(cost, price);
            profit = max(profit, price - cost);
        }
        return profit;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> prices = { 7, 1, 5, 3, 6, 4 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->maxProfit(prices);
    cout << res << endl;
    
    return 0;
}
