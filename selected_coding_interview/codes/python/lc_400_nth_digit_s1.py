"""
File: lc_400_nth_digit_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def findNthDigit(self, n: int) -> int:
        digit, start, count = 1, 1, 9
        while n > count:
            n -= count
            start *= 10 # 1, 10, 100, ...
            digit += 1  # 1,  2,  3, ...
            count = 9 * start * digit # 9, 180, 2700, ...
        num = start + (n - 1) // digit
        return int(str(num)[(n - 1) % digit])


# ======= Test Case =======
test_input = 11
expected_output = 0

# ====== Driver Code ======
slt = Solution()
result = slt.findNthDigit(test_input)
print(result)
