'''
File: sfo_57-ii_consecutive_numbers_with_sum_s_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        i, j, res = 1, 2, []
        while i < j:
            j = (-1 + (1 + 4 * (2 * target + i * i - i)) ** 0.5) / 2
            if i < j and j == int(j):
                res.append(list(range(i, int(j) + 1)))
            i += 1
        return res

# ======= Test Case =======
target = 9
# ====== Driver Code ======
slt = Solution()
res = slt.findContinuousSequence(target)
print_matrix(res)
