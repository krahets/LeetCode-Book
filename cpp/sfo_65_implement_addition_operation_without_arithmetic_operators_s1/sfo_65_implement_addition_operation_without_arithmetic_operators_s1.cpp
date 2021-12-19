/*
* File: sfo_65_implement_addition_operation_without_arithmetic_operators_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int add(int a, int b) {
        while(b != 0)
        {
            int c = (unsigned int)(a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
};

int main() {
    // ======= Test Case =======
    int a = 1;
    int b = 1;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->add(a, b);
    cout << res << endl;
    
    return 0;
}
