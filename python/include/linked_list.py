'''
File: linked_list.py
Created Time: 2021-12-11
Author: Krahets (krahets@163.com)
'''

# Definition for a singly-linked list node
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Construct a linked list from an array
def list_to_linked_list(arr):
    dum = head = ListNode(0)
    for a in arr:
        node = ListNode(a)
        head.next = node
        head = head.next
    return dum.next

# Serialize a linked list into an array
def linked_list_to_list(head):
    arr = []
    while head:
        arr.append(head.val)
        head = head.next
    return arr

# Find the first list node with val
def get_list_node(head, val):
    while head and head.val != val:
        head = head.next
    return head
