'''
File: sfo_67_convert_string_to_int_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def strToInt(self, str: str) -> int:
        res, i, sign, length = 0, 0, 1, len(str)
        int_max, int_min, bndry = 2 ** 31 - 1, -2 ** 31, 2 ** 31 // 10
        if not str: return 0         # 空字符串，提前返回
        while str[i] == ' ':
            i += 1
            if i == length: return 0 # 字符串全为空格，提前返回
        if str[i] == '-': sign = -1
        if str[i] in '+-': i += 1
        for j in range(i, length):
            if not '0' <= str[j] <= '9' : break
            if res > bndry or res == bndry and str[j] > '7':
                return int_max if sign == 1 else int_min
            res = 10 * res + ord(str[j]) - ord('0')
        return sign * res

# ======= Test Case =======
str = "42"
# ====== Driver Code ======
slt = Solution()
res = slt.strToInt(str)
print(res)
