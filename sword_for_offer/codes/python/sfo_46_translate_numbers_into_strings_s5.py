'''
File: sfo_46_translate_numbers_into_strings_s5.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def translateNum(self, num: int) -> int:
        a = b = 1
        y = num % 10
        while num > 9:
            num //= 10
            x = num % 10
            tmp = 10 * x + y
            c = a + b if 10 <= tmp <= 25 else a
            a, b = c, a
            y = x
        return a

# ======= Test Case =======
num = 12258
# ====== Driver Code ======
slt = Solution()
res = slt.translateNum(num)
print(res)
