'''
File: sfo_45_arrange_an_array_into_the_smallest_number_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def minNumber(self, nums: List[int]) -> str:
        def sort_rule(x, y):
            a, b = x + y, y + x
            if a > b: return 1
            elif a < b: return -1
            else: return 0
        
        strs = [str(num) for num in nums]
        strs.sort(key = functools.cmp_to_key(sort_rule))
        return ''.join(strs)

# ======= Test Case =======
nums = [3, 30, 34, 5, 9]
# ====== Driver Code ======
slt = Solution()
res = slt.minNumber(nums)
print(res)
