"""
File: lc_768_max_chunks_to_make_sorted_ii.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def maxChunksToSorted(self, arr: [int]) -> int:
        stack = []
        for num in arr:
            if stack and num < stack[-1]: 
                head = stack.pop()
                while stack and num < stack[-1]: stack.pop()
                stack.append(head)
            else: stack.append(num)
        return len(stack)


# ======= Test Case =======
# Test case 1
# TODO: Add appropriate test case

# ====== Driver Code ======
slt = Solution()
# result = slt.maxChunksToSorted(...)
# print(result)
