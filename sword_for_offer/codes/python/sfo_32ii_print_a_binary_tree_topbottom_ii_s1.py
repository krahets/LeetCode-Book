'''
File: sfo_32-ii_print_a_binary_tree_top-bottom_ii_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        res, queue = [], collections.deque()
        queue.append(root)
        while queue:
            tmp = []
            for _ in range(len(queue)):
                node = queue.popleft()
                tmp.append(node.val)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
            res.append(tmp)
        return res

# ======= Test Case =======
root = list_to_tree([3, 9, 20, None, None, 15, 7, None, None, None, None])
# ====== Driver Code ======
slt = Solution()
res = slt.levelOrder(root)
print_matrix(res)
