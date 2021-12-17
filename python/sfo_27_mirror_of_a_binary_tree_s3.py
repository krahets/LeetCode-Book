'''
File: sfo_27_mirror_of_a_binary_tree_s3.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def mirrorTree(self, root: TreeNode) -> TreeNode:
        if not root: return
        stack = [root]
        while stack:
            node = stack.pop()
            if node.left: stack.append(node.left)
            if node.right: stack.append(node.right)
            node.left, node.right = node.right, node.left
        return root

# ======= Test Case =======
root = list_to_tree([4, 2, 7, 1, 3, 6, 9, None, None, None, None, None, None, None, None])
# ====== Driver Code ======
slt = Solution()
res = slt.mirrorTree(root)
print_tree(res)
