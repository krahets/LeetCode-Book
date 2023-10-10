'''
File: sfo_22_the_k-th_node_from_the_end_of_a_linked_list_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def getKthFromEnd(self, head: ListNode, k: int) -> ListNode:
        former, latter = head, head
        for _ in range(k):
            former = former.next
        while former:
            former, latter = former.next, latter.next
        return latter

# ======= Test Case =======
head = list_to_linked_list([1, 2, 3, 4, 5])
k = 2
# ====== Driver Code ======
slt = Solution()
res = slt.getKthFromEnd(head, k)
print_linked_list(res)
