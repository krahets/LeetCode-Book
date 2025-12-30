/*
 * File: lc_242_valid_anagram_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length())
            return false;
        unordered_map<char, int> dic;
        for (char c : s) {
            dic[c] += 1;
        }
        for (char c : t) {
            dic[c] -= 1;
        }
        for (auto kv : dic) {
            if (kv.second != 0)
                return false;
        }
        return true;
    }
};

int main() {
    // ======= Test Case =======
    string s = "anagram", t = "nagaram";

    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->isAnagram(s, t);
    cout << (res ? "true" : "false") << endl;

    return 0;
}
