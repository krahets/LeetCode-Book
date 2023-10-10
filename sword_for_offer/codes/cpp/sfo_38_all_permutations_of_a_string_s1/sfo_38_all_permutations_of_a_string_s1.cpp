/*
* File: sfo_38_all_permutations_of_a_string_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<string> permutation(string s) {
        dfs(s, 0);
        return res;
    }
private:
    vector<string> res;
    void dfs(string s, int x) {
        if(x == s.size() - 1) {
            res.push_back(s);                       // 添加排列方案
            return;
        }
        set<int> st;
        for(int i = x; i < s.size(); i++) {
            if(st.find(s[i]) != st.end()) continue; // 重复，因此剪枝
            st.insert(s[i]);
            swap(s[i], s[x]);                       // 交换，将 s[i] 固定在第 x 位
            dfs(s, x + 1);                          // 开启固定第 x + 1 位字符
            swap(s[i], s[x]);                       // 恢复交换
        }
    }
};

int main() {
    // ======= Test Case =======
    string s = "abc";
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<string> res = slt->permutation(s);
    PrintUtil::printVector(res);
    
    return 0;
}
