"""
File: lc_110_balanced_binary_tree_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root: return True
        return abs(self.depth(root.left) - self.depth(root.right)) <= 1 and \
            self.isBalanced(root.left) and self.isBalanced(root.right)
    def depth(self, root):
        if not root: return 0
        return max(self.depth(root.left), self.depth(root.right)) + 1


# ======= Test Case =======
# Test case 1: Basic binary tree
root = list_to_tree([3, 9, 20, None, None, 15, 7])

# ====== Driver Code ======
slt = Solution()
result = slt.isBalanced(root)
print(result)
