"""
File: lc_169_majority_element_s2.py
Created Time: 2025-12-30
Author: krahets
"""

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
# Test case 1
test_input = [1, 2, 3, 4, 5]

# ====== Driver Code ======
slt = Solution()
result = slt.majorityElement(test_input)
print(result)
