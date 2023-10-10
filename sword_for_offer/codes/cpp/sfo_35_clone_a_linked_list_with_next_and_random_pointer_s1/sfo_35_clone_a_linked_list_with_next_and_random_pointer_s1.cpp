/*
* File: sfo_35_clone_a_linked_list_with_next_and_random_pointer_s1.cpp
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
        unordered_map<Node*, Node*> map;
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != nullptr) {
            map[cur] = new Node(cur->val);
            cur = cur->next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != nullptr) {
            map[cur]->next = map[cur->next];
            map[cur]->random = map[cur->random];
            cur = cur->next;
        }
        // 5. 返回新链表的头节点
        return map[head];
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
