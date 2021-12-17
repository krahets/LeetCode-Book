'''
File: sfo_53-i_find_a_number_in_a_sorted_array_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def helper(tar):
            i, j = 0, len(nums) - 1
            while i <= j:
                m = (i + j) // 2
                if nums[m] <= tar: i = m + 1
                else: j = m - 1
            return i
        return helper(target) - helper(target - 1)

# ======= Test Case =======
nums = [5, 7, 7, 8, 8, 10]
target = 8
# ====== Driver Code ======
slt = Solution()
res = slt.search(nums, target)
print(res)
