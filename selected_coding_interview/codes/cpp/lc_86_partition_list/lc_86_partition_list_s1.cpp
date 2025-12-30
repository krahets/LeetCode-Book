/*
 * File: lc_86_partition_list_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode *smlDummy = new ListNode(0), *bigDummy = new ListNode(0);
        ListNode *sml = smlDummy, *big = bigDummy;
        while (head != nullptr) {
            if (head->val < x) {
                sml->next = head;
                sml = sml->next;
            } else {
                big->next = head;
                big = big->next;
            }
            head = head->next;
        }
        sml->next = bigDummy->next;
        big->next = nullptr;
        return smlDummy->next;
    }
};

int main() {
    // ======= Test Case =======
    ListNode* head = vectorToLinkedList({1, 4, 3, 2, 5, 2});
    int x = 3;

    // ====== Driver Code ======
    Solution* slt = new Solution();
    ListNode* res = slt->partition(head, x);
    PrintUtil::printLinkedList(res);

    return 0;
}
