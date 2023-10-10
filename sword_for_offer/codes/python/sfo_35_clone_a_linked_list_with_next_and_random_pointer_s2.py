'''
File: sfo_35_clone_a_linked_list_with_next_and_random_pointer_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

# ===== Solution Code =====
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head: return
        cur = head
        # 1. 复制各节点，并构建拼接链表
        while cur:
            tmp = Node(cur.val)
            tmp.next = cur.next
            cur.next = tmp
            cur = tmp.next
        # 2. 构建各新节点的 random 指向
        cur = head
        while cur:
            if cur.random:
                cur.next.random = cur.random.next
            cur = cur.next.next
        # 3. 拆分两链表
        cur = res = head.next
        pre = head
        while cur.next:
            pre.next = pre.next.next
            cur.next = cur.next.next
            pre = pre.next
            cur = cur.next
        pre.next = None # 单独处理原链表尾节点
        return res      # 返回新链表头节点

# ======= Test Case =======
test_case = [[7, None], [13, 0], [11, 4], [10, 2], [1, 0]]
# Construct nodes
node_list = [Node(val) for val,_ in test_case]
# Build next reference
for i in range(len(test_case) - 1):
    node_list[i].next = node_list[i + 1]
# Build random reference
for i in range(len(test_case)):
    if test_case[i][1] != None:
        node_list[i].random = node_list[test_case[i][1]]
# Get the head of the linked list
head = node_list[0]
# ====== Driver Code ======
slt = Solution()
res = slt.copyRandomList(head)
# Print the copied linked list
node_list_new = []
while res:
    node_list_new.append(res)
    res = res.next 
print([[node.val, node_list_new.index(node.random) if node.random else None] for node in node_list_new])
