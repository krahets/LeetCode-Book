/*
 * File: lc_371_sum_of_two_integers_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int getSum(int a, int b) {
        // 循环，当进位为 0 时跳出
        while (b != 0) {
            int c = (unsigned int)(a & b) << 1;  // c = 进位
            a ^= b;  // a = 非进位和
            b = c;  // b = 进位
        }
        return a;
    }
};

int main() {
    // ======= Test Case =======
    int a = 1, b = 2;

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->getSum(a, b);
    cout << res << endl;

    return 0;
}
