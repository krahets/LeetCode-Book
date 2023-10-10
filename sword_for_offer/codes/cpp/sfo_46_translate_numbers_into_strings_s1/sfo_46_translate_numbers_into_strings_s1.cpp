/*
* File: sfo_46_translate_numbers_into_strings_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int translateNum(int num) {
        string s = to_string(num);
        int a = 1, b = 1, len = s.size();
        for(int i = 2; i <= len; i++) {
            string tmp = s.substr(i - 2, 2);
            int c = tmp.compare("10") >= 0 && tmp.compare("25") <= 0 ? a + b : a;
            b = a;
            a = c;
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
