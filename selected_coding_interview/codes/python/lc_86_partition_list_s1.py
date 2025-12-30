"""
File: lc_86_partition_list_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        sml_dummy, big_dummy = ListNode(0), ListNode(0)
        sml, big = sml_dummy, big_dummy
        while head:
            if head.val < x:
                sml.next = head
                sml = sml.next
            else:
                big.next = head
                big = big.next
            head = head.next
        sml.next = big_dummy.next
        big.next = None
        return sml_dummy.next


# ======= Test Case =======
# Test case 1: Basic linked list
head = list_to_linked_list([1, 4, 3, 2, 5, 2])
x = 3

# ====== Driver Code ======
slt = Solution()
result = slt.partition(head, x)
print_linked_list(result)
