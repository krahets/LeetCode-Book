"""
File: lc_287_find_the_duplicate_number_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        i = 0
        while i < len(nums):
            if nums[i] == i:
                i += 1
                continue
            if nums[nums[i]] == nums[i]: return nums[i]
            nums[nums[i]], nums[i] = nums[i], nums[nums[i]]
        return -1


# ======= Test Case =======
test_input = [1, 3, 4, 2, 2]
expected_output = 2

# ====== Driver Code ======
slt = Solution()
result = slt.findDuplicate(test_input)
print(result)
