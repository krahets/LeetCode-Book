/*
 * File: lc_509_fibonacci_number_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }
};

int main() {
    // ======= Test Case =======
    int n = 4;

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->fib(n);
    cout << res << endl;

    return 0;
}
