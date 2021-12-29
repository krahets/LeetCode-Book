'''
File: sfo_10-i_fibonacci_numbers_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
# 不考虑大数越界问题
class Solution:
    def fib(self, n: int) -> int:
        a, b = 0, 1
        for _ in range(n):
            a, b = b, a + b
        return a % 1000000007

# ======= Test Case =======
n = 5
# ====== Driver Code ======
slt = Solution()
res = slt.fib(n)
print(res)
