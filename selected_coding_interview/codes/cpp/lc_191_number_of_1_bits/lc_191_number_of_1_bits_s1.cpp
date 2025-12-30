/*
 * File: lc_191_number_of_1_bits_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int hammingWeight(uint32_t n) {
        unsigned int res = 0; // c++ 使用无符号数
        while (n != 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    uint32_t n = 0b00000000000000000000000000001011;

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->hammingWeight(n);
    cout << res << endl;

    return 0;
}
