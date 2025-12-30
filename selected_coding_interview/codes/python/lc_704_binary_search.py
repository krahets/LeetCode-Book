"""
File: lc_704_binary_search.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2
            if nums[m] < target: i = m + 1
            elif nums[m] > target: j = m - 1
            else: return m
        return -1


# ======= Test Case =======
test_input_nums = [-1, 0, 3, 5, 9, 12]
test_input_target = 9
expected_output = 4

# ====== Driver Code ======
slt = Solution()
result = slt.search(test_input_nums, test_input_target)
print(result)
