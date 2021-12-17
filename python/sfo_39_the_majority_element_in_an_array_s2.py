'''
File: sfo_39_the_majority_element_in_an_array_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        votes, count = 0, 0
        for num in nums:
            if votes == 0: x = num
            votes += 1 if num == x else -1
        # 验证 x 是否为众数
        for num in nums:
            if num == x: count += 1
        return x if count > len(nums) // 2 else 0 # 当无众数时返回 0

# ======= Test Case =======
nums = [1, 2, 3, 2, 2, 2, 5, 4, 2]
# ====== Driver Code ======
slt = Solution()
res = slt.majorityElement(nums)
print(res)
