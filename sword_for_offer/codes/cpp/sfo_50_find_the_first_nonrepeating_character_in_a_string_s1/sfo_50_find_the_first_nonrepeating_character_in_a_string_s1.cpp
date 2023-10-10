/*
* File: sfo_50_find_the_first_nonrepeating_character_in_a_string_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    char firstUniqChar(string s) {
        unordered_map<char, bool> dic;
        for(char c : s)
            dic[c] = dic.find(c) == dic.end();
        for(char c : s)
            if(dic[c]) return c;
        return ' ';
    }
};

int main() {
    // ======= Test Case =======
    string s = "abaccdeff";
    // ====== Driver Code ======
    Solution* slt = new Solution();
    char res = slt->firstUniqChar(s);
    cout << res << endl;
    
    return 0;
}
