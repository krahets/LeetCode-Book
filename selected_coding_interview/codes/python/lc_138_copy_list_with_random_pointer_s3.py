"""
File: lc_138_copy_list_with_random_pointer_s3.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        cur = head
        dum = pre = Node(0)
        while cur:
            node = Node(cur.val) # 复制节点 cur
            pre.next = node      # 新链表的 前驱节点 -> 当前节点
            # pre.random = '???' # 新链表的 「 前驱节点 -> 当前节点 」 无法确定
            cur = cur.next       # 遍历下一节点
            pre = node           # 保存当前新节点
        return dum.next


# ======= Test Case =======
# Test case 1
# TODO: Add appropriate test case

# ====== Driver Code ======
slt = Solution()
# result = slt.copyRandomList(...)
# print(result)
