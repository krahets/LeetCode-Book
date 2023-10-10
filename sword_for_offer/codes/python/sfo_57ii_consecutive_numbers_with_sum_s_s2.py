'''
File: sfo_57-ii_consecutive_numbers_with_sum_s_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        i, j, s, res = 1, 2, 3, []
        while i < j:
            if s == target:
                res.append(list(range(i, j + 1)))
            if s >= target:
                s -= i
                i += 1
            else:
                j += 1
                s += j
        return res

# ======= Test Case =======
target = 9
# ====== Driver Code ======
slt = Solution()
res = slt.findContinuousSequence(target)
print_matrix(res)
