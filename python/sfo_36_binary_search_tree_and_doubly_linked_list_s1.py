'''
File: sfo_36_binary_search_tree_and_doubly_linked_list_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# ===== Solution Code =====
class Solution:
    def treeToDoublyList(self, root: 'Node') -> 'Node':
        def dfs(cur):
            if not cur: return
            dfs(cur.left) # 递归左子树
            if self.pre: # 修改节点引用
                self.pre.right, cur.left = cur, self.pre
            else: # 记录头节点
                self.head = cur
            self.pre = cur # 保存 cur
            dfs(cur.right) # 递归右子树
        
        if not root: return
        self.pre = None
        dfs(root)
        self.head.left, self.pre.right = self.pre, self.head
        return self.head

# ======= Test Case =======
node_list = [Node(i) for i in range(1, 6)]
node_list[3].left = node_list[1]
node_list[3].right = node_list[4]
node_list[1].left = node_list[0]
node_list[1].right = node_list[2]
root = node_list[3]
# ====== Driver Code ======
slt = Solution()
res = slt.treeToDoublyList(root)
# Print the Doubly circular linked list
nodes_val = []
for _ in range(len(node_list) + 1):
    nodes_val.append(str(res.val))
    res = res.right
print(' <-> '.join(nodes_val))
