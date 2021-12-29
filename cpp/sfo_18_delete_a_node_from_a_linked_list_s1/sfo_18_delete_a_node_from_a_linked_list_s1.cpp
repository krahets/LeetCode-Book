/*
* File: sfo_18_delete_a_node_from_a_linked_list_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    ListNode* deleteNode(ListNode* head, int val) {
        if(head->val == val) return head->next;
        ListNode *pre = head, *cur = head->next;
        while(cur != nullptr && cur->val != val) {
            pre = cur;
            cur = cur->next;
        }
        if(cur != nullptr) pre->next = cur->next;
        return head;
    }
};

int main() {
    // ======= Test Case =======
    ListNode* head = vectorToLinkedList(vector<int> { 4, 5, 1, 9 });
    int val = 5;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    ListNode* res = slt->deleteNode(head, val);
    PrintUtil::printLinkedList(res);
    
    return 0;
}
