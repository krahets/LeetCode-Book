/*
* File: sfo_58ii_left_rotation_of_a_string_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        reverseString(s, 0, n - 1);
        reverseString(s, n, s.size() - 1);
        reverseString(s, 0, s.size() - 1);
        return s;
    }
private:
    void reverseString(string& s, int i, int j) {
        while(i < j) swap(s[i++], s[j--]);
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
