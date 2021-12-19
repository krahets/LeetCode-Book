/*
* File: sfo_62_josephus_problem_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
};

int main() {
    // ======= Test Case =======
    int n = 5;
    int m = 3;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->lastRemaining(n, m);
    cout << res << endl;
    
    return 0;
}
