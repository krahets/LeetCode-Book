'''
File: sfo_18_delete_a_node_from_a_linked_list_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def deleteNode(self, head: ListNode, val: int) -> ListNode:
        if head.val == val: return head.next
        pre, cur = head, head.next
        while cur and cur.val != val:
            pre, cur = cur, cur.next
        if cur: pre.next = cur.next
        return head

# ======= Test Case =======
head = list_to_linked_list([4, 5, 1, 9])
val = 5
# ====== Driver Code ======
slt = Solution()
res = slt.deleteNode(head, val)
print_linked_list(res)
