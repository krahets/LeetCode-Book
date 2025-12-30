/*
 * File: lc_387_first_unique_character_in_a_string_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char, bool> dic;
        for(char c : s)
            dic[c] = dic.find(c) == dic.end();
        for(int i = 0; i < s.size(); i++)
            if(dic[s[i]]) return i;
        return -1;
    }
};

int main() {
    // ======= Test Case =======
    string s = "leetcode";

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->firstUniqChar(s);
    cout << res << endl;

    return 0;
}
