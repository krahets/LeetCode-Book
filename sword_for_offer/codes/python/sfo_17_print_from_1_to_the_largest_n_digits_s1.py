'''
File: sfo_17_print_from_1_to_the_largest_n_digits_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def printNumbers(self, n: int) -> List[int]:
        res = []
        for i in range(1, 10 ** n):
            res.append(i)
        return res

# ======= Test Case =======
n = 1
# ====== Driver Code ======
slt = Solution()
res = slt.printNumbers(n)
print(res)
