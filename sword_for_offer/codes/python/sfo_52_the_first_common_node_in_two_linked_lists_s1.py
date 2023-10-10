'''
File: sfo_52_the_first_common_node_in_two_linked_lists_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        A, B = headA, headB
        while A != B:
            A = A.next if A else headB
            B = B.next if B else headA
        return A

# ======= Test Case =======
# Build two linked lists with intersection of 8
# headA = 4 -> 1 -> 8 -> 4 -> 5
#                   ↑
# headB = 5 -> 0 -> 1
headA = list_to_linked_list([4, 1, 8, 4, 5])
headB = list_to_linked_list([5, 0, 1, 8, 4, 5])
intersectA = get_list_node(head=headA, val=8)
intersectB = get_list_node(head=headB, val=1)
intersectB.next = intersectA # Concatenate the two lists
# ====== Driver Code ======
slt = Solution()
res = slt.getIntersectionNode(headA, headB)
print(res.val)
