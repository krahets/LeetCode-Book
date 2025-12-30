/*
 * File: lc_796_rotate_string_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool rotateString(string s, string goal) {
        return s.length() == goal.length() && (goal + goal).find(s) != -1;
    }
};

int main() {
    // ======= Test Case =======
    string s = "abcde", goal = "cdeab";

    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->rotateString(s, goal);
    cout << (res ? "true" : "false") << endl;

    return 0;
}
