'''
File: sfo_39_the_majority_element_in_an_array_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        votes = 0
        for num in nums:
            if votes == 0: x = num
            votes += 1 if num == x else -1
        return x

# ======= Test Case =======
nums = [1, 2, 3, 2, 2, 2, 5, 4, 2]
# ====== Driver Code ======
slt = Solution()
res = slt.majorityElement(nums)
print(res)
