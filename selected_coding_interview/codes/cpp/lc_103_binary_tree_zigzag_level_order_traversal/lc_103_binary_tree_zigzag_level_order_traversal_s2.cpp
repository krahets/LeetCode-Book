/*
 * File: lc_103_binary_tree_zigzag_level_order_traversal_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        queue<TreeNode*> que;
        vector<vector<int>> res;
        if (root != NULL) que.push(root);
        while (!que.empty()) {
            vector<int> tmp;
            for(int i = que.size(); i > 0; i--) {
                TreeNode* node = que.front();
                que.pop();
                tmp.push_back(node->val);
                if (node->left != NULL) que.push(node->left);
                if (node->right != NULL) que.push(node->right);
            }
            if (res.size() % 2 == 1) reverse(tmp.begin(),tmp.end());
            res.push_back(tmp);
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    // TODO: Add specific test case

    // ====== Driver Code ======
    Solution* slt = new Solution();
    // TODO: Call solution method and print result

    return 0;
}
