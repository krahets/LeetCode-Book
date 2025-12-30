/*
 * File: lc_21_merge_two_sorted_lists_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* dum = new ListNode(0);
        ListNode* cur = dum;
        while (list1 != nullptr && list2 != nullptr) {
            if (list1->val < list2->val) {
                cur->next = list1;
                list1 = list1->next;
            }
            else {
                cur->next = list2;
                list2 = list2->next;
            }
            cur = cur->next;
        }
        cur->next = list1 != nullptr ? list1 : list2;
        return dum->next;
    }
};

int main() {
    // ======= Test Case =======
    ListNode* list1 = vectorToLinkedList({1, 2, 4});
    ListNode* list2 = vectorToLinkedList({1, 3, 4});

    // ====== Driver Code ======
    Solution* slt = new Solution();
    ListNode* res = slt->mergeTwoLists(list1, list2);
    PrintUtil::printLinkedList(res);

    return 0;
}
