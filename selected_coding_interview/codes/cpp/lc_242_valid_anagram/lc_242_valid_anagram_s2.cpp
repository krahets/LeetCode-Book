/*
 * File: lc_242_valid_anagram_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool isAnagram(string s, string t) {
        // 若 s, t 长度不同，则不互为重排
        if (s.length() != t.length())
            return false;
        // 初始化哈希表 dic
        unordered_map<char, int> dic;
        // 统计字符串 s 各字符数量，遇到 +1
        for (char c : s) {
            dic[c] += 1;
        }
        // 统计字符串 t 各字符数量，遇到 -1
        for (char c : t) {
            dic[c] -= 1;
        }
        // 遍历 s, t 中各字符的数量差
        for (auto kv : dic) {
            // 若 s, t 中某字符的数量不一致，则不互为重排
            if (kv.second != 0)
                return false;
        }
        // 所有字符数量都一致，因此互为重排
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
