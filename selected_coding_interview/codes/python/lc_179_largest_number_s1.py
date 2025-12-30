"""
File: lc_179_largest_number_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def sort_rule(x, y):
            a, b = x + y, y + x
            if a < b: return 1
            elif a > b: return -1
            else: return 0
        strs = [str(num) for num in nums]
        strs.sort(key = cmp_to_key(sort_rule))
        if strs[0] == "0":
            return "0"
        return ''.join(strs)


# ======= Test Case =======
# Test case 1
test_input = [1, 2, 3, 4, 5]

# ====== Driver Code ======
slt = Solution()
result = slt.largestNumber(test_input)
print(result)
