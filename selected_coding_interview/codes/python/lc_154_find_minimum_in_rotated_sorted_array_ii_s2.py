"""
File: lc_154_find_minimum_in_rotated_sorted_array_ii_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def findMin(self, nums: [int]) -> int:
        i, j = 0, len(nums) - 1
        while i < j:
            m = (i + j) // 2
            if nums[m] > nums[j]: i = m + 1
            elif nums[m] < nums[j]: j = m
            else: return min(nums[i:j])
        return nums[i]


# ======= Test Case =======
# Test case 1
test_input = [1, 2, 3, 4, 5]

# ====== Driver Code ======
slt = Solution()
result = slt.findMin(test_input)
print(result)
