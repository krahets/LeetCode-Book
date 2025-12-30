"""
File: lc_426_convert_binary_search_tree_to_sorted_doubly_linked_list_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def treeToDoublyList(self, root: 'TreeNode') -> 'TreeNode':
        # 打印中序遍历
        def dfs(cur):
            if not cur: return
            dfs(cur.left)  # 左
            if self.pre:
                self.pre.right, cur.left = cur, self.pre
            else:
                self.head = cur
            self.pre = cur
            dfs(cur.right) # 右

        if not root: return
        self.pre = None
        dfs(root)
        self.head.left, self.pre.right = self.pre, self.head
        return self.head


# ======= Test Case =======
# Test case 1: Simple BST
root = list_to_tree([4, 2, 5, 1, 3])

# ====== Driver Code ======
slt = Solution()
result = slt.treeToDoublyList(root)
print("Head value:", result.val if result else None)
