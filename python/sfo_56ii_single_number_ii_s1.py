'''
File: sfo_56-ii_single_number_ii_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ones, twos = 0, 0
        for num in nums:
            ones = ones ^ num & ~twos
            twos = twos ^ num & ~ones
        return ones

# ======= Test Case =======
nums = [3, 4, 3, 3]
# ====== Driver Code ======
slt = Solution()
res = slt.singleNumber(nums)
print(res)
