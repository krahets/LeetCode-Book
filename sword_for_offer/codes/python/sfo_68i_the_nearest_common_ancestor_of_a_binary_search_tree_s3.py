'''
File: sfo_68-i_the_nearest_common_ancestor_of_a_binary_search_tree_s3.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

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
root = list_to_tree([6, 2, 8, 0, 4, 7, 9, None, None, 3, 5, None, None, None, None, None, None, None, None])
p = get_tree_node(root=root, val=2)
q = get_tree_node(root=root, val=8)
# ====== Driver Code ======
slt = Solution()
res = slt.lowestCommonAncestor(root, p, q)
print(res.val)
