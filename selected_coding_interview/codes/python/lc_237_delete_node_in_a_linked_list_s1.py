"""
File: lc_237_delete_node_in_a_linked_list_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def deleteNode(self, node):
        node.val = node.next.val
        node.next = node.next.next


# ======= Test Case =======
# Test case 1
# TODO: Add appropriate test case

# ====== Driver Code ======
slt = Solution()
# result = slt.deleteNode(...)
# print(result)
