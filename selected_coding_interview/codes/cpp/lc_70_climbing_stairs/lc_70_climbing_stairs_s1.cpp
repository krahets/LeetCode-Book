/*
 * File: lc_70_climbing_stairs_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int climbStairs(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n - 1; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
};

int main() {
    // ======= Test Case =======
    int n = 2;

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->climbStairs(n);
    cout << res << endl;

    return 0;
}
