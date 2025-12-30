"""
File: lc_105_construct_binary_tree_from_preorder_and_inorder_traversal.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def recur(root, left, right):
            if left > right: return                               # 递归终止
            node = TreeNode(preorder[root])                       # 建立根节点
            i = dic[preorder[root]]                               # 划分根节点、左子树、右子树
            node.left = recur(root + 1, left, i - 1)              # 开启左子树递归
            node.right = recur(i - left + root + 1, i + 1, right) # 开启右子树递归
            return node                                           # 回溯返回根节点
        dic, preorder = {}, preorder
        for i in range(len(inorder)):
            dic[inorder[i]] = i
        return recur(0, 0, len(inorder) - 1)


# ======= Test Case =======
test_input_preorder = [3, 9, 20, 15, 7]
test_input_inorder = [9, 3, 15, 20, 7]

# ====== Driver Code ======
slt = Solution()
result = slt.buildTree(test_input_preorder, test_input_inorder)
print_tree(result)
