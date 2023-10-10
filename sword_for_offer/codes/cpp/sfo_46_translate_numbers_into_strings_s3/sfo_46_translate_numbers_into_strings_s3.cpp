/*
* File: sfo_46_translate_numbers_into_strings_s3.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num > 9) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
};

int main() {
    // ======= Test Case =======
    int num = 12258;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->translateNum(num);
    cout << res << endl;
    
    return 0;
}
