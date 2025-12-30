/*
 * File: lc_110_balanced_binary_tree_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if (root == nullptr) return true;
        return abs(depth(root->left) - depth(root->right)) <= 1 && isBalanced(root->left) && isBalanced(root->right);
    }
private:
    int depth(TreeNode* root) {
        if (root == nullptr) return 0;
        return max(depth(root->left), depth(root->right)) + 1;
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
