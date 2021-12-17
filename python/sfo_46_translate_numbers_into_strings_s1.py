'''
File: sfo_46_translate_numbers_into_strings_s1.py
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
            a, b = (a + b if "10" <= s[i - 2:i] <= "25" else a), a
        return a

# ======= Test Case =======
num = 12258
# ====== Driver Code ======
slt = Solution()
res = slt.translateNum(num)
print(res)
