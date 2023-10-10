/*
* File: sfo_55ii_balanced_binary_tree_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
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
    TreeNode* root = vectorToTree(vector<int> { 3, 9, 20, INT_MAX, INT_MAX, 15, 7, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->isBalanced(root);
    cout << boolalpha << res << endl;
    
    return 0;
}
