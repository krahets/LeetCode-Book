/*
 * File: lc_102_binary_tree_level_order_traversal_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> que;
        vector<vector<int>> res;
        if (root != nullptr) que.push(root);
        while (!que.empty()) {
            vector<int> tmp;
            for(int i = que.size(); i > 0; --i) {
                root = que.front();
                que.pop();
                tmp.push_back(root->val);
                if (root->left != nullptr) que.push(root->left);
                if (root->right != nullptr) que.push(root->right);
            }
            res.push_back(tmp);
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree({3, 9, 20, INT_MAX, INT_MAX, 15, 7});

    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<vector<int>> res = slt->levelOrder(root);
    PrintUtil::printVectorMatrix(res);

    return 0;
}
