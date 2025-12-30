"""
File: lc_371_sum_of_two_integers.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def getSum(self, a: int, b: int) -> int:
        x = 0xffffffff
        a, b = a & x, b & x
        # 循环，当进位为 0 时跳出
        while b != 0:
            # a, b = 非进位和, 进位
            a, b = (a ^ b), (a & b) << 1 & x
        return a if a <= 0x7fffffff else ~(a ^ x)


# ======= Test Case =======
# Test case 1
# TODO: Add appropriate test case

# ====== Driver Code ======
slt = Solution()
# result = slt.getSum(...)
# print(result)
