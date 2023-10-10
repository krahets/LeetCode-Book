'''
File: sfo_06_print_a_linked_list_in_reverse_order_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def reversePrint(self, head: ListNode) -> List[int]:
        stack = []
        while head:
            stack.append(head.val)
            head = head.next
        return stack[::-1]

# ======= Test Case =======
head = list_to_linked_list([1, 3, 2])
# ====== Driver Code ======
slt = Solution()
res = slt.reversePrint(head)
print(res)
