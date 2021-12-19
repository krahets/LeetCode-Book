/*
* File: sfo_58ii_left_rotation_of_a_string_s3.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        reverse(s.begin(), s.begin() + n);
        reverse(s.begin() + n, s.end());
        reverse(s.begin(), s.end());
        return s;
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
