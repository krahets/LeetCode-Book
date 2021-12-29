/*
* File: sfo_60_probabilities_for_rolling_n_dices_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<double> dicesProbability(int n) {
        vector<double> dp(6, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            vector<double> tmp(5 * i + 1, 0);
            for (int j = 0; j < dp.size(); j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
};

int main() {
    // ======= Test Case =======
    int n = 2;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<double> res = slt->dicesProbability(n);
    PrintUtil::printVector(res);
    
    return 0;
}
