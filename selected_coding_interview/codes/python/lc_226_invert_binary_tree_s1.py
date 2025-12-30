"""
File: lc_226_invert_binary_tree_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return
        tmp = root.left
        root.left = self.invertTree(root.right)
        root.right = self.invertTree(tmp)
        return root


# ======= Test Case =======
# Test case 1: Basic binary tree
root = list_to_tree([3, 9, 20, None, None, 15, 7])

# ====== Driver Code ======
slt = Solution()
result = slt.invertTree(root)
print(result)
