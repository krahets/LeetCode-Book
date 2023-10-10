'''
File: sfo_28_symmetric_binary_tree_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def recur(L, R):
            if not L and not R: return True
            if not L or not R or L.val != R.val: return False
            return recur(L.left, R.right) and recur(L.right, R.left)

        return not root or recur(root.left, root.right)

# ======= Test Case =======
root = list_to_tree([1, 2, 2, 3, 4, 4, 3, None, None, None, None, None, None, None, None])
# ====== Driver Code ======
slt = Solution()
res = slt.isSymmetric(root)
print(res)
