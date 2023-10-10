'''
File: sfo_15_number_of_1_bits_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        while n:
            res += n & 1
            n >>= 1
        return res

# ======= Test Case =======
n = 11
# ====== Driver Code ======
slt = Solution()
res = slt.hammingWeight(n)
print(res)
