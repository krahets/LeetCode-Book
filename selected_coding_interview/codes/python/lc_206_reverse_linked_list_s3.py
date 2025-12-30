"""
File: lc_206_reverse_linked_list_s3.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        def recur(cur, pre):
            if not cur: return pre     # 终止条件
            res = recur(cur.next, cur) # 递归后继节点
            cur.next = pre             # 修改节点引用指向
            return res                 # 返回反转链表的头节点
        return recur(head, None)       # 调用递归并返回


# ======= Test Case =======
# Test case 1: Basic linked list
head = list_to_linked_list([1, 2, 3, 4, 5])

# ====== Driver Code ======
slt = Solution()
result = slt.reverseList(head)
print_linked_list(result)
