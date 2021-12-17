'''
File: sfo_10-i_fibonacci_numbers_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def fib(self, n: int) -> int:
        a, b = 0, 1
        for _ in range(n):
            a, b = b, (a + b) % 1000000007
        return a

# ======= Test Case =======
n = 5
# ====== Driver Code ======
slt = Solution()
res = slt.fib(n)
print(res)
