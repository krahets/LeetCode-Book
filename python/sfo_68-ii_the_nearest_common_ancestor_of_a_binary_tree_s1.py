'''
File: sfo_68-ii_the_nearest_common_ancestor_of_a_binary_tree_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        if not root or root == p or root == q: return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if not left: return right
        if not right: return left
        return root

# ======= Test Case =======
root = list_to_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4, None, None, None, None, None, None, None, None])
p = get_tree_node(root=root, val=5)
q = get_tree_node(root=root, val=1)
# ====== Driver Code ======
slt = Solution()
res = slt.lowestCommonAncestor(root, p, q)
print(res.val)
