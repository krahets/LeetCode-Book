'''
File: sfo_55-i_depth_of_a_binary_tree_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root: return 0
        queue, res = [root], 0
        while queue:
            tmp = []
            for node in queue:
                if node.left: tmp.append(node.left)
                if node.right: tmp.append(node.right)
            queue = tmp
            res += 1
        return res

# ======= Test Case =======
root = list_to_tree([3, 9, 20, None, None, 15, 7, None, None, None, None])
# ====== Driver Code ======
slt = Solution()
res = slt.maxDepth(root)
print(res)
