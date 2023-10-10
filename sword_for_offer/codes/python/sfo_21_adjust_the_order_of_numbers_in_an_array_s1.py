'''
File: sfo_21_adjust_the_order_of_numbers_in_an_array_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def exchange(self, nums: List[int]) -> List[int]:
        i, j = 0, len(nums) - 1
        while i < j:
            while i < j and nums[i] & 1 == 1: i += 1
            while i < j and nums[j] & 1 == 0: j -= 1
            nums[i], nums[j] = nums[j], nums[i]
        return nums

# ======= Test Case =======
nums = [1, 2, 3, 4]
# ====== Driver Code ======
slt = Solution()
res = slt.exchange(nums)
print(res)
