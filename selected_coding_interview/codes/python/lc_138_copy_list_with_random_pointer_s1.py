"""
File: lc_138_copy_list_with_random_pointer_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head: return None
        dic = {}
        # 复制各节点，并建立 "原节点 -> 新节点" 的 Map 映射
        cur = head
        while cur:
            dic[cur] = Node(cur.val)
            cur = cur.next
        cur = head
        # 构建新节点的 next 和 random 指向
        while cur:
            dic[cur].next = dic.get(cur.next)
            dic[cur].random = dic.get(cur.random)
            cur = cur.next
        # 返回新链表的头节点
        return dic[head]


# ======= Test Case =======
# Test case 1: Simple linked list with random pointers
# Creating nodes: [[7,null],[13,0],[11,4],[10,2],[1,0]]
node1 = Node(7)
node2 = Node(13)
node3 = Node(11)
node4 = Node(10)
node5 = Node(1)
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5
node2.random = node1
node3.random = node5
node4.random = node3
node5.random = node1

# ====== Driver Code ======
slt = Solution()
result = slt.copyRandomList(node1)
print("Copied list head value:", result.val if result else None)
