/*
 * File: lc_191_number_of_1_bits_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
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
