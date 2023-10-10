'''
File: sfo_47_the_maximum_value_of_gifts_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        for j in range(1, n): # 初始化第一行
            grid[0][j] += grid[0][j - 1]
        for i in range(1, m): # 初始化第一列
            grid[i][0] += grid[i - 1][0]
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += max(grid[i][j - 1], grid[i - 1][j])
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
