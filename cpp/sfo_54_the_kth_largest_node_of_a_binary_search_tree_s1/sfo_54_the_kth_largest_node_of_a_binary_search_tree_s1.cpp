/*
* File: sfo_54_the_kth_largest_node_of_a_binary_search_tree_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int kthLargest(TreeNode* root, int k) {
        this->k = k;
        dfs(root);
        return res;
    }
private:
    int res, k;
    void dfs(TreeNode* root) {
        if(root == nullptr) return;
        dfs(root->right);
        if(k == 0) return;
        if(--k == 0) res = root->val;
        dfs(root->left);
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree(vector<int> { 3, 1, 4, INT_MAX, 2, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    int k = 1;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->kthLargest(root, k);
    cout << res << endl;
    
    return 0;
}
