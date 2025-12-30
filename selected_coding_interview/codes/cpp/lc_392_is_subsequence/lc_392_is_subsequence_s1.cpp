/*
 * File: lc_392_is_subsequence_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool isSubsequence(string s, string t) {
        if (s.size() == 0) return true;
        for (int i = 0, j = 0; j < t.size(); j++) {
            if (s[i] == t[j]) {
                // 若已经遍历完 s ，则提前返回 true
                if (++i == s.size())
                    return true;
            }
        }
        return false;
    }
};

int main() {
    // ======= Test Case =======
    // TODO: Add specific test case

    // ====== Driver Code ======
    Solution* slt = new Solution();
    // TODO: Call solution method and print result

    return 0;
}
