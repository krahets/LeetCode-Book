/*
* File: sfo_48_the_longest_substring_without_repeated_characters_s3.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> dic;
        int i = -1, res = 0, len = s.size();
        for(int j = 0; j < len; j++) {
            if(dic.find(s[j]) != dic.end())
                i = max(i, dic.find(s[j])->second); // 更新左指针
            dic[s[j]] = j; // 哈希表记录
            res = max(res, j - i); // 更新结果
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
