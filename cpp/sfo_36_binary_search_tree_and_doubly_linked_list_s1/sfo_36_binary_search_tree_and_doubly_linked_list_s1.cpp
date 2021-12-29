/*
* File: sfo_36_binary_search_tree_and_doubly_linked_list_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

/**
 * Definition for a linked list node.
 */
struct Node {
    int val;
    Node *left;
    Node *right;
    Node(int x) : val(x), left(nullptr), right(nullptr) {}
};

// ===== Solution Code =====
class Solution {
public:
    Node* treeToDoublyList(Node* root) {
        if(root == nullptr) return nullptr;
        dfs(root);
        head->left = pre;
        pre->right = head;
        return head;
    }
private:
    Node *pre, *head;
    void dfs(Node* cur) {
        if(cur == nullptr) return;
        dfs(cur->left);
        if(pre != nullptr) pre->right = cur;
        else head = cur;
        cur->left = pre;
        pre = cur;
        dfs(cur->right);
    }
};

int main() {
    // ======= Test Case =======
    vector<Node*> nodeList = {
        new Node(1),
        new Node(2),
        new Node(3),
        new Node(4),
        new Node(5)
    };
    nodeList[3]->left = nodeList[1];
    nodeList[3]->right = nodeList[4];
    nodeList[1]->left = nodeList[0];
    nodeList[1]->right = nodeList[2];
    Node* root = nodeList[3];

    // ====== Driver Code ======
    Solution* slt = new Solution();
    Node* res = slt->treeToDoublyList(root);
    // Print the Doubly circular linked list
    vector<int> nodesVal;
    for (int i = 0; i <= nodeList.size(); i++) {
        nodesVal.push_back(res->val);
        res = res->right;
    }
    cout << PrintUtil::strJoin(" <-> ", nodesVal) << endl;
    
    return 0;
}
