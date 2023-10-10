/*
* File: sfo_32i_print_a_binary_tree_topbottom_i_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> levelOrder(TreeNode* root) {
        vector<int> res;
        if(!root) return res;
        queue<TreeNode*> que;
        que.push(root);
        while(!que.empty()){
            TreeNode* node = que.front();
            que.pop();
            res.push_back(node->val);
            if(node->left) que.push(node->left);
            if(node->right) que.push(node->right);
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree(vector<int> { 3, 9, 20, INT_MAX, INT_MAX, 15, 7, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->levelOrder(root);
    PrintUtil::printVector(res);
    
    return 0;
}
