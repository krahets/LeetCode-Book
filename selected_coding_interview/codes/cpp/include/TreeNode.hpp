/*
 * File: TreeNode.hpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#pragma once

#include <climits>
#include <queue>
#include <vector>
using namespace std;

/**
 * @brief Definition for a binary tree node
 *
 */
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {
    }
};

/**
 * @brief Generate a binary tree with a vector
 *
 * @param list
 * @return TreeNode*
 */
TreeNode *vectorToTree(vector<int> list) {
    if (list.empty() || list[0] == INT_MAX) return nullptr;
    TreeNode *root = new TreeNode(list[0]);
    queue<TreeNode *> que;
    que.emplace(root);
    int i = 1;
    while (!que.empty() && i < list.size()) {
        TreeNode *node = que.front();
        que.pop();
        if (i < list.size() && list[i] != INT_MAX) {
            node->left = new TreeNode(list[i]);
            que.emplace(node->left);
        }
        i++;
        if (i < list.size() && list[i] != INT_MAX) {
            node->right = new TreeNode(list[i]);
            que.emplace(node->right);
        }
        i++;
    }
    return root;
}

/**
 * @brief Get a tree node with specific value in a binary tree
 *
 * @param root
 * @param val
 * @return TreeNode*
 */
TreeNode *getTreeNode(TreeNode *root, int val) {
    if (root == nullptr)
        return nullptr;
    if (root->val == val)
        return root;
    TreeNode *left = getTreeNode(root->left, val);
    TreeNode *right = getTreeNode(root->right, val);
    return left != nullptr ? left : right;
}
