'''
File: sfo_58-ii_left_rotation_of_a_string_s4.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def reverseLeftWords(self, s: str, n: int) -> str:
        res = ""
        for i in range(n, len(s)):
            res += s[i]
        for i in range(n):
            res += s[i]
        return res

# ======= Test Case =======
s = "abcdefg"
n = 2
# ====== Driver Code ======
slt = Solution()
res = slt.reverseLeftWords(s, n)
print(res)
