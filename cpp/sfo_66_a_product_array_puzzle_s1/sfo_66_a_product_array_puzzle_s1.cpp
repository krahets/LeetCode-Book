/*
* File: sfo_66_a_product_array_puzzle_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> constructArr(vector<int>& a) {
        int len = a.size();
        if(len == 0) return {};
        vector<int> b(len, 1);
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> a = { 1, 2, 3, 4, 5 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->constructArr(a);
    PrintUtil::printVector(res);
    
    return 0;
}
