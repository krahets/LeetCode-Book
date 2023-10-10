/*
* File: sfo_32ii_print_a_binary_tree_topbottom_ii_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> que;
        vector<vector<int>> res;
        int cnt = 0;
        if(root != NULL) que.push(root);
        while(!que.empty()) {
            vector<int> tmp;
            for(int i = que.size(); i > 0; --i) {
                root = que.front();
                que.pop();
                tmp.push_back(root->val);
                if(root->left != NULL) que.push(root->left);
                if(root->right != NULL) que.push(root->right);
            }
            res.push_back(tmp);
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree(vector<int> { 3, 9, 20, INT_MAX, INT_MAX, 15, 7, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<vector<int>> res = slt->levelOrder(root);
    PrintUtil::printVectorMatrix(res);
    
    return 0;
}
