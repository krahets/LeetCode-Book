'''
File: sfo_58-ii_left_rotation_of_a_string_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def reverseLeftWords(self, s: str, n: int) -> str:
        return s[n:] + s[:n]

# ======= Test Case =======
s = "abcdefg"
n = 2
# ====== Driver Code ======
slt = Solution()
res = slt.reverseLeftWords(s, n)
print(res)
