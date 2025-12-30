/*
 * File: lc_226_invert_binary_tree_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (root == nullptr) return nullptr;
        stack<TreeNode*> stack;
        stack.push(root);
        while (!stack.empty())
        {
            TreeNode* node = stack.top();
            stack.pop();
            if (node->left != nullptr) stack.push(node->left);
            if (node->right != nullptr) stack.push(node->right);
            TreeNode* tmp = node->left;
            node->left = node->right;
            node->right = tmp;
        }
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
