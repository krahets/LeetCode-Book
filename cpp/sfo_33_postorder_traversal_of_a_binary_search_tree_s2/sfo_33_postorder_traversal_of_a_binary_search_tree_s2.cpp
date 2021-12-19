/*
* File: sfo_33_postorder_traversal_of_a_binary_search_tree_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool verifyPostorder(vector<int>& postorder) {
        stack<int> stk;
        int root = INT_MAX;
        for(int i = postorder.size() - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stk.empty() && stk.top() > postorder[i]) {
                root = stk.top();
                stk.pop();
            }
            stk.push(postorder[i]);
        }
        return true;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> postorder = { 1, 6, 3, 2, 5 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->verifyPostorder(postorder);
    cout << boolalpha << res << endl;
    
    return 0;
}
