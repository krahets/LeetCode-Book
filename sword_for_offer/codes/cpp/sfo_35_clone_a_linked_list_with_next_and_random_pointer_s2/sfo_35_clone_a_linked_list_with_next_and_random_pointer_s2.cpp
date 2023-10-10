/*
* File: sfo_35_clone_a_linked_list_with_next_and_random_pointer_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

/**
 * Definition for a linked list node.
 */
struct Node {
    int val;
    Node *next;
    Node *random;
    Node(int x) : val(x), next(nullptr), random(nullptr) {}
};

// ===== Solution Code =====
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head == nullptr) return nullptr;
        Node* cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != nullptr) {
            Node* tmp = new Node(cur->val);
            tmp->next = cur->next;
            cur->next = tmp;
            cur = tmp->next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != nullptr) {
            if(cur->random != nullptr)
                cur->next->random = cur->random->next;
            cur = cur->next->next;
        }
        // 3. 拆分两链表
        cur = head->next;
        Node* pre = head, *res = head->next;
        while(cur->next != nullptr) {
            pre->next = pre->next->next;
            cur->next = cur->next->next;
            pre = pre->next;
            cur = cur->next;
        }
        pre->next = nullptr; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nodesVal { 7, 13, 11, 10, 1 };
    vector<int> nodesRandom { INT_MAX, 0, 4, 2, 0 }; // Represent the 'null' Node with 'INT_MAX'
    // Construct nodes
    vector<Node*> nodeList;
    for (int val : nodesVal) {
        nodeList.push_back(new Node(val));
    }
    // Build next reference
    for (int i = 0; i < nodesVal.size() - 1; i++) {
        nodeList[i]->next = nodeList[i + 1];
    }
    // Build random reference
    for (int i = 0; i < nodesVal.size(); i++) {
        if (nodesRandom[i] != INT_MAX)
            nodeList[i]->random = nodeList[nodesRandom[i]];
    }
    // Get the head of the linked list
    Node* head = nodeList[0];

    // ====== Driver Code ======
    Solution* slt = new Solution();
    Node* res = slt->copyRandomList(head);
    // Print the copied linked list
    vector<Node*> nodeListNew;
    while (res != nullptr) {
        nodeListNew.push_back(res);
        res = res->next;
    }
    vector<vector<int>> printArr(nodeListNew.size(), vector<int> (2));
    for (int i = 0; i < nodeListNew.size(); i++) {
        Node* node = nodeListNew[i];
        printArr[i][0] = node->val;
        printArr[i][1] = PrintUtil::vecFind(nodeListNew, node->random);
    }
    PrintUtil::printVectorMatrix(printArr);
    
    return 0;
}
