/*
 * File: lc_226_invert_binary_tree_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (root == nullptr) return nullptr;
        TreeNode* tmp = root->left;
        root->left = invertTree(root->right);
        root->right = invertTree(tmp);
        return root;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree({4, 2, 7, 1, 3, 6, 9});

    // ====== Driver Code ======
    Solution* slt = new Solution();
    TreeNode* res = slt->invertTree(root);
    PrintUtil::printTree(res);

    return 0;
}
