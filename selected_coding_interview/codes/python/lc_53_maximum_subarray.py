"""
File: lc_53_maximum_subarray.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        for i in range(1, len(nums)):
            nums[i] += max(nums[i - 1], 0)
        return max(nums)


# ======= Test Case =======
# Test case 1
test_input = [1, 2, 3, 4, 5]

# ====== Driver Code ======
slt = Solution()
result = slt.maxSubArray(test_input)
print(result)
