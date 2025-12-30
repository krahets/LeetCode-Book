"""
File: lc_1480_running_sum_of_1d_array.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        dp = [0] * len(nums)
        dp[0] = nums[0]
        for i in range(1, len(nums)):
            dp[i] = dp[i - 1] + nums[i]
        return dp


# ======= Test Case =======
# Test case 1
test_input = [1, 2, 3, 4, 5]

# ====== Driver Code ======
slt = Solution()
result = slt.runningSum(test_input)
print(result)
