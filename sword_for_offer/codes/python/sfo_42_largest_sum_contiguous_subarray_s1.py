'''
File: sfo_42_largest_sum_contiguous_subarray_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        for i in range(1, len(nums)):
            nums[i] += max(nums[i - 1], 0)
        return max(nums)

# ======= Test Case =======
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
# ====== Driver Code ======
slt = Solution()
res = slt.maxSubArray(nums)
print(res)
