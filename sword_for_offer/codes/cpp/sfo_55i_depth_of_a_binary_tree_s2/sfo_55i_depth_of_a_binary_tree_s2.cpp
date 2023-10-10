/*
* File: sfo_55i_depth_of_a_binary_tree_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(root == nullptr) return 0;
        vector<TreeNode*> que;
        que.push_back(root);
        int res = 0;
        while(!que.empty()) {
            vector<TreeNode*> tmp;
            for(TreeNode* node : que) {
                if(node->left != nullptr) tmp.push_back(node->left);
                if(node->right != nullptr) tmp.push_back(node->right);
            }
            que = tmp;
            res++;
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree(vector<int> { 3, 9, 20, INT_MAX, INT_MAX, 15, 7, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->maxDepth(root);
    cout << res << endl;
    
    return 0;
}
