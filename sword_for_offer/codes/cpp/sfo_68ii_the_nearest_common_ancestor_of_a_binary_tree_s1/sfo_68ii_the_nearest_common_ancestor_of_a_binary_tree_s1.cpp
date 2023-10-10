/*
* File: sfo_68ii_the_nearest_common_ancestor_of_a_binary_tree_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr || root == p || root == q) return root;
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        if(left == nullptr) return right;
        if(right == nullptr) return left;
        return root;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree(vector<int> { 3, 5, 1, 6, 2, 0, 8, INT_MAX, INT_MAX, 7, 4, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    TreeNode* p = getTreeNode(root, 5);
    TreeNode* q = getTreeNode(root, 1);
    // ====== Driver Code ======
    Solution* slt = new Solution();
    TreeNode* res = slt->lowestCommonAncestor(root, p, q);
    cout << res->val << endl;
    
    return 0;
}
