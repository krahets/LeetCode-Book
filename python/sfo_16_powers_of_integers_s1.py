'''
File: sfo_16_powers_of_integers_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x == 0.0: return 0.0
        res = 1
        if n < 0: x, n = 1 / x, -n
        while n:
            if n & 1: res *= x
            x *= x
            n >>= 1
        return res

# ======= Test Case =======
x = 2.0
n = 10
# ====== Driver Code ======
slt = Solution()
res = slt.myPow(x, n)
print(res)
