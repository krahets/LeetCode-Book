"""
File: lc_206_reverse_linked_list_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        cur, pre = head, None
        while cur:
            cur.next, pre, cur = pre, cur, cur.next
        return pre


# ======= Test Case =======
# Test case 1: Basic linked list
head = list_to_linked_list([1, 2, 3, 4, 5])

# ====== Driver Code ======
slt = Solution()
result = slt.reverseList(head)
print_linked_list(result)
