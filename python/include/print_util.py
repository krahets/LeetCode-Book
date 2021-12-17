'''
File: print_util.py
Created Time: 2021-12-11
Author: Krahets (krahets@163.com)
'''

from .binary_tree import TreeNode, tree_to_list
from .linked_list import ListNode, linked_list_to_list

# Print a matrix
def print_matrix(mat):
    pstr = []
    for arr in mat:
        pstr.append('  ' + str(arr))

    print('[\n' + ',\n'.join(pstr) + '\n]')

# Print a linked list
def print_linked_list(head):
    arr = linked_list_to_list(head)
    print(' -> '.join([str(a) for a in arr]))

# Print a binary tree (90º counter-clockwise rotated)
def print_tree(root):
    def helper(root, level):
        if not root:
            return
        helper(root.right, level + 1)
        print(' ' * 4 * level + '->', root.val)
        helper(root.left, level + 1)
    helper(root, 0)