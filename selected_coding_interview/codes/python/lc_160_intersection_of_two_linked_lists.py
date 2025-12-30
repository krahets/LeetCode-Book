"""
File: lc_160_intersection_of_two_linked_lists.py
Created Time: 2025-12-30
Author: krahets
"""

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
# Test case 1: Two linked lists with intersection
headA = list_to_linked_list([4, 1, 8, 4, 5])
headB = list_to_linked_list([5, 6, 1, 8, 4, 5])

# ====== Driver Code ======
slt = Solution()
result = slt.getIntersectionNode(headA, headB)
print("Intersection node value:", result.val if result else None)
