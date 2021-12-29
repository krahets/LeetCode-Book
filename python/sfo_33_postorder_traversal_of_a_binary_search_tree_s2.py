'''
File: sfo_33_post-order_traversal_of_a_binary_search_tree_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def verifyPostorder(self, postorder: List[int]) -> bool:
        stack, root = [], float("+inf")
        for i in range(len(postorder) - 1, -1, -1):
            if postorder[i] > root: return False
            while(stack and postorder[i] < stack[-1]):
                root = stack.pop()
            stack.append(postorder[i])
        return True

# ======= Test Case =======
postorder = [1, 6, 3, 2, 5]
# ====== Driver Code ======
slt = Solution()
res = slt.verifyPostorder(postorder)
print(res)
