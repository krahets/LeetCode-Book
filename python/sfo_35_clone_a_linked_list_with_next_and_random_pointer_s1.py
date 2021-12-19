'''
File: sfo_35_clone_a_linked_list_with_next_and_random_pointer_s1.py
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
        dic = {}
        # 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        cur = head
        while cur:
            dic[cur] = Node(cur.val)
            cur = cur.next
        cur = head
        # 4. 构建新节点的 next 和 random 指向
        while cur:
            dic[cur].next = dic.get(cur.next)
            dic[cur].random = dic.get(cur.random)
            cur = cur.next
        # 5. 返回新链表的头节点
        return dic[head]

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
