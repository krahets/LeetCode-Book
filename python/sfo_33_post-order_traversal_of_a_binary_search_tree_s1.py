'''
File: sfo_33_post-order_traversal_of_a_binary_search_tree_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def verifyPostorder(self, postorder: List[int]) -> bool:
        def recur(i, j):
            if i >= j: return True
            p = i
            while postorder[p] < postorder[j]: p += 1
            m = p
            while postorder[p] > postorder[j]: p += 1
            return p == j and recur(i, m - 1) and recur(m, j - 1)

        return recur(0, len(postorder) - 1)

# ======= Test Case =======
postorder = [1, 6, 3, 2, 5]
# ====== Driver Code ======
slt = Solution()
res = slt.verifyPostorder(postorder)
print(res)
