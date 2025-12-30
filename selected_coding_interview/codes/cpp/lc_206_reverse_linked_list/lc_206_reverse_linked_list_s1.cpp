/*
 * File: lc_206_reverse_linked_list_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *cur = head, *pre = nullptr;
        while(cur != nullptr) {
            ListNode* tmp = cur->next; // 暂存后继节点 cur.next
            cur->next = pre;           // 修改 next 引用指向
            pre = cur;                 // pre 暂存 cur
            cur = tmp;                 // cur 访问下一节点
        }
        return pre;
    }
};

int main() {
    // ======= Test Case =======
    ListNode* head = vectorToLinkedList({1, 2, 3, 4, 5});

    // ====== Driver Code ======
    Solution* slt = new Solution();
    ListNode* res = slt->reverseList(head);
    PrintUtil::printLinkedList(res);

    return 0;
}
