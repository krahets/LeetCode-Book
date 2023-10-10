'''
File: sfo_03_find_duplicate_numbers_in_an_array_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        i = 0
        while i < len(nums):
            if nums[i] == i:
                i += 1
                continue
            if nums[nums[i]] == nums[i]: return nums[i]
            nums[nums[i]], nums[i] = nums[i], nums[nums[i]]
        return -1

# ======= Test Case =======
nums = [2, 3, 1, 0, 2, 5, 3]
# ====== Driver Code ======
slt = Solution()
res = slt.findRepeatNumber(nums)
print(res)
