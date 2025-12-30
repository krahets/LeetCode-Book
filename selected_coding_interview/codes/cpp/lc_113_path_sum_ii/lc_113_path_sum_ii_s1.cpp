/*
 * File: lc_113_path_sum_ii_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        recur(root, targetSum);
        return res;
    }
private:
    vector<vector<int>> res;
    vector<int> path;
    void recur(TreeNode* root, int tar) {
        if (root == nullptr) return;
        path.push_back(root->val);
        tar -= root->val;
        if (tar == 0 && root->left == nullptr && root->right == nullptr)
            res.push_back(path);
        recur(root->left, tar);
        recur(root->right, tar);
        path.pop_back();
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
