/*
 * File: lc_206_reverse_linked_list_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        return recur(head, nullptr);           // 调用递归并返回
    }
private:
    ListNode* recur(ListNode* cur, ListNode* pre) {
        if (cur == nullptr) return pre;        // 终止条件
        ListNode* res = recur(cur->next, cur); // 递归后继节点
        cur->next = pre;                       // 修改节点引用指向
        return res;                            // 返回反转链表的头节点
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
