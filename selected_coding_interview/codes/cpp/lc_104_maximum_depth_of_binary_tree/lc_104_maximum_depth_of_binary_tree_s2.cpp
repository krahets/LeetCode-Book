/*
 * File: lc_104_maximum_depth_of_binary_tree_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        vector<TreeNode*> que;
        que.push_back(root);
        int res = 0;
        while (!que.empty()) {
            vector<TreeNode*> tmp;
            for(TreeNode* node : que) {
                if (node->left != nullptr) tmp.push_back(node->left);
                if (node->right != nullptr) tmp.push_back(node->right);
            }
            que = tmp;
            res++;
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree({3, 9, 20, INT_MAX, INT_MAX, 15, 7});

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->maxDepth(root);
    cout << res << endl;

    return 0;
}
