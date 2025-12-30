"""
File: lc_235_lowest_common_ancestor_of_a_binary_search_tree_s3.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        return root


# ======= Test Case =======
# Test case 1: Basic binary tree
root = list_to_tree([3, 9, 20, None, None, 15, 7])

# ====== Driver Code ======
slt = Solution()
result = slt.lowestCommonAncestor(root, root.left, root.right)
print(result)
