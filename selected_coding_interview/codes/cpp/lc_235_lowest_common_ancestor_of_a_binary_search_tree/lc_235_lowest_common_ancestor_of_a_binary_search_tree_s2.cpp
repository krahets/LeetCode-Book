/*
 * File: lc_235_lowest_common_ancestor_of_a_binary_search_tree_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (p->val > q->val)
            swap(p, q);
        while (root != nullptr) {
            if (root->val < p->val) // p,q 都在 root 的右子树中
                root = root->right; // 遍历至右子节点
            else if (root->val > q->val) // p,q 都在 root 的左子树中
                root = root->left; // 遍历至左子节点
            else break;
        }
        return root;
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
