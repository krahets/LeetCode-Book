/*
* File: sfo_14i_cut_the_rope_i_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return pow(3, a);
        if(b == 1) return pow(3, a - 1) * 4;
        return pow(3, a) * 2;
    }
};

int main() {
    // ======= Test Case =======
    int n = 10;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->cuttingRope(n);
    cout << res << endl;
    
    return 0;
}
