'''
File: sfo_47_the_maximum_value_of_gifts_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i == 0 and j == 0: continue
                if i == 0: grid[i][j] += grid[i][j - 1]
                elif j == 0: grid[i][j] += grid[i - 1][j]
                else: grid[i][j] += max(grid[i][j - 1], grid[i - 1][j])
        return grid[-1][-1]

# ======= Test Case =======
grid = [
    [1, 3, 1],
    [1, 5, 1],
    [4, 2, 1]
]
# ====== Driver Code ======
slt = Solution()
res = slt.maxValue(grid)
print(res)
