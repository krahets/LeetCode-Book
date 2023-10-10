/*
* File: sfo_26_substructure_of_a_binary_tree_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool isSubStructure(TreeNode* A, TreeNode* B) {
        return (A != nullptr && B != nullptr) && (recur(A, B) || isSubStructure(A->left, B) || isSubStructure(A->right, B));
    }
private:
    bool recur(TreeNode* A, TreeNode* B) {
        if(B == nullptr) return true;
        if(A == nullptr || A->val != B->val) return false;
        return recur(A->left, B->left) && recur(A->right, B->right);
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* A = vectorToTree(vector<int> { 3, 4, 5, 1, 2, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    TreeNode* B = vectorToTree(vector<int> { 4, 1, INT_MAX, INT_MAX, INT_MAX });
    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->isSubStructure(A, B);
    cout << boolalpha << res << endl;
    
    return 0;
}
