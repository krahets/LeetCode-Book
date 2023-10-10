'''
File: sfo_26_substructure_of_a_binary_tree_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def isSubStructure(self, A: TreeNode, B: TreeNode) -> bool:
        def recur(A, B):
            if not B: return True
            if not A or A.val != B.val: return False
            return recur(A.left, B.left) and recur(A.right, B.right)

        return bool(A and B) and (recur(A, B) or self.isSubStructure(A.left, B) or self.isSubStructure(A.right, B))

# ======= Test Case =======
A = list_to_tree([3, 4, 5, 1, 2, None, None, None, None, None, None])
B = list_to_tree([4, 1, None, None, None])
# ====== Driver Code ======
slt = Solution()
res = slt.isSubStructure(A, B)
print(res)
