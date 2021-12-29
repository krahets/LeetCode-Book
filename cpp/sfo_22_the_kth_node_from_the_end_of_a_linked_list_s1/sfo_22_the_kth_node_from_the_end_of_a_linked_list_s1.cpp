/*
* File: sfo_22_the_kth_node_from_the_end_of_a_linked_list_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    ListNode* getKthFromEnd(ListNode* head, int k) {
        ListNode *former = head, *latter = head;
        for(int i = 0; i < k; i++)
            former = former->next;
        while(former != nullptr) {
            former = former->next;
            latter = latter->next;
        }
        return latter;
    }
};

int main() {
    // ======= Test Case =======
    ListNode* head = vectorToLinkedList(vector<int> { 1, 2, 3, 4, 5 });
    int k = 2;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    ListNode* res = slt->getKthFromEnd(head, k);
    PrintUtil::printLinkedList(res);
    
    return 0;
}
