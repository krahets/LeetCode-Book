"""
File: lc_233_number_of_digit_one_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def countDigitOne(self, n: int) -> int:
        high = n // 10
        cur = n % 10
        low = 0
        digit = 1 # 个位
        res = 0
        while high != 0 or cur != 0:
            if cur == 0: res += high * digit
            elif cur == 1: res += high * digit + low + 1
            else: res += (high + 1) * digit
            low += cur * digit
            cur = high % 10
            high //= 10
            digit *= 10
        return res


# ======= Test Case =======
test_input = 12
expected_output = 5

# ====== Driver Code ======
slt = Solution()
result = slt.countDigitOne(test_input)
print(result)
