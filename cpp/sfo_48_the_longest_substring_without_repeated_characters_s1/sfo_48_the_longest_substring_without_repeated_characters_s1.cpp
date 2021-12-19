/*
* File: sfo_48_the_longest_substring_without_repeated_characters_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> dic;
        int res = 0, tmp = 0, len = s.size(), i;
        for(int j = 0; j < len; j++) {
            if(dic.find(s[j]) == dic.end()) i = - 1;
            else i = dic.find(s[j])->second; // 获取索引 i
            dic[s[j]] = j; // 更新哈希表
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
