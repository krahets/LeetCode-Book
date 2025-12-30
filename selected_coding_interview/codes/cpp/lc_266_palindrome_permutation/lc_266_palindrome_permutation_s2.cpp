/*
 * File: lc_266_palindrome_permutation_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool canPermutePalindrome(string s) {
        // 初始化哈希表
        unordered_map<char, int> dic;
        // 统计字符串中各字符的数量
        for (char c : s) {
            dic[c] += 1;
        }
        int odd = 0;
        for (auto kv : dic) {
            // 统计“数量为奇数”字符的个数
            if (kv.second % 2 == 1) {
                // 若“数量为奇数”的字符个数 > 1 ，则不是回文串排列
                if (++odd > 1) // 注意 ++odd > 1 是先执行 odd 自增，再执行逻辑判断； odd++ 的顺序反之
                    return false;
            }
        }
        // 若“数量为奇数”的字符个数 <= 1 ，则是回文串排列
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
