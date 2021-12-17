'''
File: sfo_62_josephus_problem_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def lastRemaining(self, n: int, m: int) -> int:
        x = 0
        for i in range(2, n + 1):
            x = (x + m) % i
        return x

# ======= Test Case =======
n = 5
m = 3
# ====== Driver Code ======
slt = Solution()
res = slt.lastRemaining(n, m)
print(res)
