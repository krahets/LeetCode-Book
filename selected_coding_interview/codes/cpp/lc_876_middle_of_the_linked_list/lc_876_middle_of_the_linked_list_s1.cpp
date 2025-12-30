/*
 * File: lc_876_middle_of_the_linked_list_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode *fast = head, *slow = head;
        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }
        return slow;
    }
};

int main() {
    // ======= Test Case =======
    ListNode* head = vectorToLinkedList({1, 2, 3, 4, 5});

    // ====== Driver Code ======
    Solution* slt = new Solution();
    ListNode* res = slt->middleNode(head);
    PrintUtil::printLinkedList(res);

    return 0;
}
