'''
File: sfo_54_the_k-th_largest_node_of_a_binary_search_tree_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def kthLargest(self, root: TreeNode, k: int) -> int:
        def dfs(root):
            if not root: return
            dfs(root.right)
            if self.k == 0: return
            self.k -= 1
            if self.k == 0: self.res = root.val
            dfs(root.left)

        self.k = k
        dfs(root)
        return self.res

# ======= Test Case =======
root = list_to_tree([3, 1, 4, None, 2, None, None, None, None])
k = 1
# ====== Driver Code ======
slt = Solution()
res = slt.kthLargest(root, k)
print(res)
