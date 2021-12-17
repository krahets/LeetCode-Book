'''
File: sfo_05_replace_spaces_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def replaceSpace(self, s: str) -> str:
        res = []
        for c in s:
            if c == ' ': res.append("%20")
            else: res.append(c)
        return "".join(res)

# ======= Test Case =======
s = "We are happy."
# ====== Driver Code ======
slt = Solution()
res = slt.replaceSpace(s)
print(res)
