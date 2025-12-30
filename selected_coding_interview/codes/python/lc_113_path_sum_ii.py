"""
File: lc_113_path_sum_ii.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res, path = [], []
        def recur(root, tar):
            if not root: return
            path.append(root.val)
            tar -= root.val
            if tar == 0 and not root.left and not root.right:
                res.append(list(path))
            recur(root.left, tar)
            recur(root.right, tar)
            path.pop()
        recur(root, targetSum)
        return res


# ======= Test Case =======
# Test case 1: Basic binary tree
root = list_to_tree([5, 4, 8, 11, None, 13, 4, 7, 2, None, None, 5, 1])
targetSum = 22

# ====== Driver Code ======
slt = Solution()
result = slt.pathSum(root, targetSum)
print(result)
