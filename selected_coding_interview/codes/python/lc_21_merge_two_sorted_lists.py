"""
File: lc_21_merge_two_sorted_lists.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        cur = dum = ListNode(0)
        while list1 and list2:
            if list1.val < list2.val:
                cur.next, list1 = list1, list1.next
            else:
                cur.next, list2 = list2, list2.next
            cur = cur.next
        cur.next = list1 if list1 else list2
        return dum.next


# ======= Test Case =======
# Test case 1: Two sorted linked lists
list1 = list_to_linked_list([1, 2, 4])
list2 = list_to_linked_list([1, 3, 4])

# ====== Driver Code ======
slt = Solution()
result = slt.mergeTwoLists(list1, list2)
print_linked_list(result)
