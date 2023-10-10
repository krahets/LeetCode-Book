'''
File: sfo_65_implement_addition_operation_without_arithmetic_operators_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def add(self, a: int, b: int) -> int:
        x = 0xffffffff
        a, b = a & x, b & x
        while b != 0:
            a, b = (a ^ b), (a & b) << 1 & x
        return a if a <= 0x7fffffff else ~(a ^ x)

# ======= Test Case =======
a = 1
b = 1
# ====== Driver Code ======
slt = Solution()
res = slt.add(a, b)
print(res)
