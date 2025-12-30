"""
File: lc_264_ugly_number_ii.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        res, a, b, c = [1] * n, 0, 0, 0
        for i in range(1, n):
            n2, n3, n5 = res[a] * 2, res[b] * 3, res[c] * 5
            res[i] = min(n2, n3, n5)
            if res[i] == n2: a += 1
            if res[i] == n3: b += 1
            if res[i] == n5: c += 1
        return res[-1]


# ======= Test Case =======
# Test case 1
# TODO: Add appropriate test case

# ====== Driver Code ======
slt = Solution()
# result = slt.nthUglyNumber(...)
# print(result)
