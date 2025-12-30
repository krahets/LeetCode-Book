"""
File: lc_8_string_to_integer_atoi_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()                      # 删除首尾空格
        if not s: return 0                   # 字符串为空则直接返回
        res, i, sign = 0, 1, 1
        int_max, int_min, bndry = 2 ** 31 - 1, -2 ** 31, 2 ** 31 // 10
        if s[0] == '-': sign = -1            # 保存负号
        elif s[0] != '+': i = 0              # 若无符号位，则需从 i = 0 开始数字拼接
        for c in s[i:]:
            if not '0' <= c <= '9' : break     # 遇到非数字的字符则跳出
            if res > bndry or res == bndry and c > '7': return int_max if sign == 1 else int_min # 数字越界处理
            res = 10 * res + ord(c) - ord('0') # 数字拼接
        return sign * res


# ======= Test Case =======
# Test case 1
test_input = "example"

# ====== Driver Code ======
slt = Solution()
result = slt.myAtoi(test_input)
print(result)
