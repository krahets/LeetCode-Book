"""
File: lc_136_single_number.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        x = 0
        for num in nums:  # 1. 遍历 nums 执行异或运算
            x ^= num      
        return x;         # 2. 返回出现一次的数字 x


# ======= Test Case =======
# Test case 1
test_input = [1, 2, 3, 4, 5]

# ====== Driver Code ======
slt = Solution()
result = slt.singleNumber(test_input)
print(result)
