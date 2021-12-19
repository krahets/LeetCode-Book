/*
* File: sfo_64_solve_1_2___n_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int sumNums(int n) {
        n > 1 && (n += sumNums(n - 1));
        return n;
    }
};

int main() {
    // ======= Test Case =======
    int n = 3;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->sumNums(n);
    cout << res << endl;
    
    return 0;
}
