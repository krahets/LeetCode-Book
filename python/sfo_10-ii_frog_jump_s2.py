'''
File: sfo_10-ii_frog_jump_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
# 不考虑大数越界问题
class Solution:
    def numWays(self, n: int) -> int:
        a, b = 1, 1
        for _ in range(n):
            a, b = b, a + b
        return a % 1000000007

# ======= Test Case =======
n = 7
# ====== Driver Code ======
slt = Solution()
res = slt.numWays(n)
print(res)
