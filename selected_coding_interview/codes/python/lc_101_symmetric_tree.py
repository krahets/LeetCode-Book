"""
File: lc_101_symmetric_tree.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def recur(L, R):
            if not L and not R: return True
            if not L or not R or L.val != R.val: return False
            return recur(L.left, R.right) and recur(L.right, R.left)
        return not root or recur(root.left, root.right)


# ======= Test Case =======
# Test case 1: Basic binary tree
root = list_to_tree([3, 9, 20, None, None, 15, 7])

# ====== Driver Code ======
slt = Solution()
result = slt.isSymmetric(root)
print(result)
