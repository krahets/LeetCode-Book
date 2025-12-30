"""
File: lc_287_find_the_duplicate_number_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        hmap = set()
        for num in nums:
            if num in hmap: return num
            hmap.add(num)
        return -1


# ======= Test Case =======
# Test case 1
test_input = [1, 2, 3, 4, 5]

# ====== Driver Code ======
slt = Solution()
result = slt.findDuplicate(test_input)
print(result)
