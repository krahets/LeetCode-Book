'''
File: sfo_11_find_minimum_in_rotated_sorted_array_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def minArray(self, numbers: List[int]) -> int:
        i, j = 0, len(numbers) - 1
        while i < j:
            m = (i + j) // 2
            if numbers[m] > numbers[j]: i = m + 1
            elif numbers[m] < numbers[j]: j = m
            else: return min(numbers[i:j])
        return numbers[i]

# ======= Test Case =======
numbers = [3, 4, 5, 1, 2]
# ====== Driver Code ======
slt = Solution()
res = slt.minArray(numbers)
print(res)
