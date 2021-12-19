/*
* File: sfo_58ii_left_rotation_of_a_string_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        return s.substr(n, s.size()) + s.substr(0, n);
    }
};

int main() {
    // ======= Test Case =======
    string s = "abcdefg";
    int n = 2;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    string res = slt->reverseLeftWords(s, n);
    cout << res << endl;
    
    return 0;
}
