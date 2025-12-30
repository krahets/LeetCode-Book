"""
File: lc_8_string_to_integer_atoi_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def myAtoi(self, s: str) -> int:
        res, i, sign, length = 0, 0, 1, len(s)
        int_max, int_min, bndry = 2 ** 31 - 1, -2 ** 31, 2 ** 31 // 10
        if not s: return 0         # 空字符串，提前返回
        while s[i] == ' ':
            i += 1
            if i == length: return 0 # 字符串全为空格，提前返回
        if s[i] == '-': sign = -1
        if s[i] in '+-': i += 1
        for j in range(i, length):
            if not '0' <= s[j] <= '9' : break
            if res > bndry or res == bndry and s[j] > '7':
                return int_max if sign == 1 else int_min
            res = 10 * res + ord(s[j]) - ord('0')
        return sign * res


# ======= Test Case =======
# Test case 1
test_input = "example"

# ====== Driver Code ======
slt = Solution()
result = slt.myAtoi(test_input)
print(result)
