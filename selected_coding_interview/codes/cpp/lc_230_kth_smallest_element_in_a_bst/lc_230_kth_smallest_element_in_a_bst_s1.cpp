/*
 * File: lc_230_kth_smallest_element_in_a_bst_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        this->k = k;
        dfs(root);
        return res;
    }
private:
    int res, k;
    void dfs(TreeNode* root) {
        if (root == nullptr) return;
        dfs(root->left);
        if (k == 0) return;
        if (--k == 0) res = root->val;
        dfs(root->right);
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree({3, 1, 4, INT_MAX, 2});
    int k = 1;

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->kthSmallest(root, k);
    cout << res << endl;

    return 0;
}
