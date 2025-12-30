"""
File: lc_86_partition_list_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        # 新建两个链表
        sml_dummy, big_dummy = ListNode(0), ListNode(0)
        # 遍历链表
        sml, big = sml_dummy, big_dummy
        while head:
            # 将 < x 的节点加入 sml 节点后
            if head.val < x:
                sml.next = head
                sml = sml.next
            # 将 >= x 的节点加入 big 节点后
            else:
                big.next = head
                big = big.next
            head = head.next
        # 拼接两链表
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
