/*
 * File: lc_138_copy_list_with_random_pointer_s3.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node* cur = head;
        Node* dum = new Node(0), *pre = dum;
        while(cur != nullptr) {
            Node* node = new Node(cur->val); // 复制节点 cur
            pre->next = node;                // 新链表的 前驱节点 -> 当前节点
            // pre->random = "???";          // 新链表的 「 前驱节点 -> 当前节点 」 无法确定
            cur = cur->next;                 // 遍历下一节点
            pre = node;                      // 保存当前新节点
        }
        return dum->next;
    }
};

int main() {
    // ======= Test Case =======
    // TODO: Add specific test case

    // ====== Driver Code ======
    Solution* slt = new Solution();
    // TODO: Call solution method and print result

    return 0;
}
