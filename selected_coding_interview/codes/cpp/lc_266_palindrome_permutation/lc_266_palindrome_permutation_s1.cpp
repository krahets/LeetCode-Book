/*
 * File: lc_266_palindrome_permutation_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool canPermutePalindrome(string s) {
        unordered_map<char, int> dic;
        for (char c : s) {
            dic[c] += 1;
        }
        int odd = 0;
        for (auto kv : dic) {
            if (kv.second % 2 == 1) {
                if (++odd > 1)
                    return false;
            }
        }
        return true;
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
