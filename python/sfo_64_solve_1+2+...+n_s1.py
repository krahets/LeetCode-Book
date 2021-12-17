'''
File: sfo_64_solve_1+2+...+n_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def __init__(self):
        self.res = 0
    def sumNums(self, n: int) -> int:
        n > 1 and self.sumNums(n - 1)
        self.res += n
        return self.res

# ======= Test Case =======
n = 3
# ====== Driver Code ======
slt = Solution()
res = slt.sumNums(n)
print(res)
