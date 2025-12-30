"""
File: lc_876_middle_of_the_linked_list.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        return slow


# ======= Test Case =======
# Test case 1: Basic linked list
head = list_to_linked_list([1, 2, 3, 4, 5])

# ====== Driver Code ======
slt = Solution()
result = slt.middleNode(head)
print_linked_list(result)
