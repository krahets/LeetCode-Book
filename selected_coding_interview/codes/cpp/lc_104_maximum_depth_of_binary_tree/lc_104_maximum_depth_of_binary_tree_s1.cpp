/*
 * File: lc_104_maximum_depth_of_binary_tree_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
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
