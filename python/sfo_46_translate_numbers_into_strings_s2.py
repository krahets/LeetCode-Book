'''
File: sfo_46_translate_numbers_into_strings_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def translateNum(self, num: int) -> int:
        s = str(num)
        a = b = 1
        for i in range(2, len(s) + 1):
            tmp = s[i - 2:i]
            c = a + b if "10" <= tmp <= "25" else a
            b = a
            a = c
        return a

# ======= Test Case =======
num = 12258
# ====== Driver Code ======
slt = Solution()
res = slt.translateNum(num)
print(res)
