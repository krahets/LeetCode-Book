"""
File: lc_400_nth_digit_s3.py
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
            start *= 10
            digit += 1
            count = 9 * start * digit
        num = start + (n - 1) // digit
        s = str(num) # 转化为 string
        res = int(s[(n - 1) % digit]) # 获得 num 的 第 (n - 1) % digit 个数位，并转化为 int
        return res


# ======= Test Case =======
test_input = 11
expected_output = 0

# ====== Driver Code ======
slt = Solution()
result = slt.findNthDigit(test_input)
print(result)
