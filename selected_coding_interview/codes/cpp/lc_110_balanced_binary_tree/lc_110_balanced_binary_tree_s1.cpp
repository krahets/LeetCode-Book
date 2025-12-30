/*
 * File: lc_110_balanced_binary_tree_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        return recur(root) != -1;
    }
private:
    int recur(TreeNode* root) {
        if (root == nullptr) return 0;
        int left = recur(root->left);
        if (left == -1) return -1;
        int right = recur(root->right);
        if (right == -1) return -1;
        return abs(left - right) < 2 ? max(left, right) + 1 : -1;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree({3, 9, 20, INT_MAX, INT_MAX, 15, 7});

    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->isBalanced(root);
    cout << (res ? "true" : "false") << endl;

    return 0;
}
