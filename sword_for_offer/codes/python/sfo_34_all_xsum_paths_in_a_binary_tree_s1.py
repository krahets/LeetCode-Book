'''
File: sfo_34_all_x-sum_paths_in_a_binary_tree_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
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

        recur(root, sum)
        return res

# ======= Test Case =======
root = list_to_tree([5, 4, 8, 11, None, 13, 4, 7, 2, None, None, 5, 1, None, None, None, None, None, None, None, None])
sum = 22
# ====== Driver Code ======
slt = Solution()
res = slt.pathSum(root, sum)
print_matrix(res)
