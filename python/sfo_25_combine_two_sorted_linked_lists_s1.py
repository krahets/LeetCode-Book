'''
File: sfo_25_combine_two_sorted_linked_lists_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        cur = dum = ListNode(0)
        while l1 and l2:
            if l1.val < l2.val:
                cur.next, l1 = l1, l1.next
            else:
                cur.next, l2 = l2, l2.next
            cur = cur.next
        cur.next = l1 if l1 else l2
        return dum.next

# ======= Test Case =======
l1 = list_to_linked_list([1, 2, 4])
l2 = list_to_linked_list([1, 3, 4])
# ====== Driver Code ======
slt = Solution()
res = slt.mergeTwoLists(l1, l2)
print_linked_list(res)
