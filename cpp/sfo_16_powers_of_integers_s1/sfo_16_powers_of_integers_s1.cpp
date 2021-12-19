/*
* File: sfo_16_powers_of_integers_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    double myPow(double x, int n) {
        if(x == 0.0f) return 0.0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    double x = 2.0;
    int n = 10;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    double res = slt->myPow(x, n);
    cout << res << endl;
    
    return 0;
}
