'''
File: sfo_53-ii_the_missing_number_from_0_to_n-1_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2
            if nums[m] == m: i = m + 1
            else: j = m - 1
        return i

# ======= Test Case =======
nums = [0, 1, 3]
# ====== Driver Code ======
slt = Solution()
res = slt.missingNumber(nums)
print(res)
