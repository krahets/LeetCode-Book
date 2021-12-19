/*
* File: sfo_68i_the_nearest_common_ancestor_of_a_binary_search_tree_s3.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root->val < p->val && root->val < q->val)
            return lowestCommonAncestor(root->right, p, q);
        if(root->val > p->val && root->val > q->val)
            return lowestCommonAncestor(root->left, p, q);
        return root;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree(vector<int> { 6, 2, 8, 0, 4, 7, 9, INT_MAX, INT_MAX, 3, 5, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    TreeNode* p = new TreeNode(2);
    TreeNode* q = new TreeNode(8);
    // ====== Driver Code ======
    Solution* slt = new Solution();
    TreeNode* res = slt->lowestCommonAncestor(root, p, q);
    cout << res->val << endl;
    
    return 0;
}
