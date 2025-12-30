"""
File: lc_103_binary_tree_zigzag_level_order_traversal_s3.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        res, queue = [], collections.deque()
        queue.append(root)
        while queue:
            tmp = []
            for _ in range(len(queue)):
                node = queue.popleft()
                tmp.append(node.val)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
            res.append(tmp[::-1] if len(res) % 2 else tmp)
        return res


# ======= Test Case =======
# Test case 1: Basic binary tree
root = list_to_tree([3, 9, 20, None, None, 15, 7])

# ====== Driver Code ======
slt = Solution()
result = slt.zigzagLevelOrder(root)
print(result)
