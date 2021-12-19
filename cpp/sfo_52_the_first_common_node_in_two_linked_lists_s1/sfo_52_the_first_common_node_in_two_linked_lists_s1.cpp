/*
* File: sfo_52_the_first_common_node_in_two_linked_lists_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    ListNode* getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *A = headA, *B = headB;
        while (A != B) {
            A = A != nullptr ? A->next : headB;
            B = B != nullptr ? B->next : headA;
        }
        return A;
    }
};

int main() {
    // ======= Test Case =======
    // Build two linked lists with intersection of 8
    // headA = 4 -> 1 -> 8 -> 4 -> 5
    //                   ↑
    // headB = 5 -> 0 -> 1
    ListNode* headA = vectorToLinkedList(vector<int> { 4, 1, 8, 4, 5 });
    ListNode* headB = vectorToLinkedList(vector<int> { 5, 0, 1, 8, 4, 5 });
    ListNode* intersectA = getListNode(headA, 8);
    ListNode* intersectB = getListNode(headB, 1);
    intersectB->next = intersectA; // Concatenate the two lists
    // ====== Driver Code ======
    Solution* slt = new Solution();
    ListNode* res = slt->getIntersectionNode(headA, headB);
    cout << res->val << endl;

    return 0;
}
