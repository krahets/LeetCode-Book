"""
File: lc_400_nth_digit_s4.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def findNthDigit(self, n: int) -> int:
        digit, start, count = 1, 1, 9
        while n > count: # 1.
            n -= count
            start *= 10
            digit += 1
            count = 9 * start * digit
        num = start + (n - 1) // digit # 2.
        return int(str(num)[(n - 1) % digit]) # 3.


# ======= Test Case =======
test_input = 11
expected_output = 0

# ====== Driver Code ======
slt = Solution()
result = slt.findNthDigit(test_input)
print(result)
