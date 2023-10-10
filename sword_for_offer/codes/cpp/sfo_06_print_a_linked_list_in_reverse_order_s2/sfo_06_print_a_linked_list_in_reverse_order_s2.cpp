/*
* File: sfo_06_print_a_linked_list_in_reverse_order_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
        stack<int> stk;
        while(head != nullptr) {
            stk.push(head->val);
            head = head->next;
        }
        vector<int> res;
        while(!stk.empty()) {
            res.push_back(stk.top());
            stk.pop();
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    ListNode* head = vectorToLinkedList(vector<int> { 1, 3, 2 });
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->reversePrint(head);
    PrintUtil::printVector(res);
    
    return 0;
}
