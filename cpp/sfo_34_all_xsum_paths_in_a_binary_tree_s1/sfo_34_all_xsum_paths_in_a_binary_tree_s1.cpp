/*
* File: sfo_34_all_xsum_paths_in_a_binary_tree_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        recur(root, sum);
        return res;
    }
private:
    vector<vector<int>> res;
    vector<int> path;
    void recur(TreeNode* root, int tar) {
        if(root == nullptr) return;
        path.push_back(root->val);
        tar -= root->val;
        if(tar == 0 && root->left == nullptr && root->right == nullptr)
            res.push_back(path);
        recur(root->left, tar);
        recur(root->right, tar);
        path.pop_back();
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree(vector<int> { 5, 4, 8, 11, INT_MAX, 13, 4, 7, 2, INT_MAX, INT_MAX, 5, 1, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    int sum = 22;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<vector<int>> res = slt->pathSum(root, sum);
    PrintUtil::printVectorMatrix(res);
    
    return 0;
}
