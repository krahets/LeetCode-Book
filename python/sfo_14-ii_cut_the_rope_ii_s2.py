'''
File: sfo_14-ii_cut_the_rope_ii_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
# 由于语言特性，Python 可以不考虑大数越界问题
class Solution:
    def cuttingRope(self, n: int) -> int:
        if n <= 3: return n - 1
        a, b, p = n // 3, n % 3, 1000000007
        if b == 0: return 3 ** a % p
        if b == 1: return 3 ** (a - 1) * 4 % p
        return 3 ** a * 2 % p

# ======= Test Case =======
n = 10
# ====== Driver Code ======
slt = Solution()
res = slt.cuttingRope(n)
print(res)
