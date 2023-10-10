/*
* File: sfo_32iii_print_a_binary_tree_topbottom_iii_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        deque<TreeNode*> deque;
        vector<vector<int>> res;
        if(root != NULL) deque.push_back(root);
        while(!deque.empty()) {
            // 打印奇数层
            vector<int> tmp;
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode* node = deque.front();
                deque.pop_front();
                tmp.push_back(node->val);
                // 先左后右加入下层节点
                if(node->left != NULL) deque.push_back(node->left);
                if(node->right != NULL) deque.push_back(node->right);
            }
            res.push_back(tmp);
            if(deque.empty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp.clear();
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode* node = deque.back();
                deque.pop_back();
                tmp.push_back(node->val);
                // 先右后左加入下层节点
                if(node->right != NULL) deque.push_front(node->right);
                if(node->left != NULL) deque.push_front(node->left);
            }
            res.push_back(tmp);
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    TreeNode* root = vectorToTree(vector<int> { 3, 9, 20, INT_MAX, INT_MAX, 15, 7, INT_MAX, INT_MAX, INT_MAX, INT_MAX });
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<vector<int>> res = slt->levelOrder(root);
    PrintUtil::printVectorMatrix(res);
    
    return 0;
}
