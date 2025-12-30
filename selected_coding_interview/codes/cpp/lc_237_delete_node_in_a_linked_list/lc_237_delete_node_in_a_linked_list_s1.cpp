/*
 * File: lc_237_delete_node_in_a_linked_list_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    void deleteNode(ListNode* node) {
        node->val = node->next->val;
        node->next = node->next->next;
    }
};

int main() {
    // ======= Test Case =======
    ListNode* head = vectorToLinkedList({4, 5, 1, 9});
    ListNode* node = getListNode(head, 5);

    // ====== Driver Code ======
    Solution* slt = new Solution();
    slt->deleteNode(node);
    PrintUtil::printLinkedList(head);

    return 0;
}
