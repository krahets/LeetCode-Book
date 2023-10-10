/*
* File: sfo_48_the_longest_substring_without_repeated_characters_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int res = 0, tmp = 0, len = s.size();
        for(int j = 0; j < len; j++) {
            int i = j - 1;
            while(i >= 0 && s[i] != s[j]) i--; // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    string s = "abcabcbb";
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->lengthOfLongestSubstring(s);
    cout << res << endl;
    
    return 0;
}
