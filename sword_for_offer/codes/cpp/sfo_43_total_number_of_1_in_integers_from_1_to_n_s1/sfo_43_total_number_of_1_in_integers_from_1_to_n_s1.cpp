/*
* File: sfo_43_total_number_of_1_in_integers_from_1_to_n_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int countDigitOne(int n) {
        long digit = 1;
        int high = n / 10, cur = n % 10, low = 0, res = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    int n = 12;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->countDigitOne(n);
    cout << res << endl;
    
    return 0;
}
