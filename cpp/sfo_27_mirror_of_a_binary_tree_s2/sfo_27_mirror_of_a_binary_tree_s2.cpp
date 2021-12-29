/*
* File: sfo_27_mirror_of_a_binary_tree_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    TreeNode* mirrorTree(TreeNode* root) {
        if(root == nullptr) return nullptr;
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
    TreeNode* root = vectorToTree(vector<int> { 4, 2, 7, 1, 3, 6, 9, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    // ====== Driver Code ======
    Solution* slt = new Solution();
    TreeNode* res = slt->mirrorTree(root);
    PrintUtil::printTree(res);
    
    return 0;
}
