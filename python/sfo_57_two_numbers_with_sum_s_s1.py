'''
File: sfo_57_two_numbers_with_sum_s_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        i, j = 0, len(nums) - 1
        while i < j:
            s = nums[i] + nums[j]
            if s > target: j -= 1
            elif s < target: i += 1
            else: return nums[i], nums[j]
        return []

# ======= Test Case =======
nums = [2, 7, 11, 15]
target = 9
# ====== Driver Code ======
slt = Solution()
res = slt.twoSum(nums, target)
print(res)
