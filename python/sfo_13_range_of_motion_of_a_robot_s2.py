'''
File: sfo_13_range_of_motion_of_a_robot_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def movingCount(self, m: int, n: int, k: int) -> int:
        queue, visited = [(0, 0, 0, 0)], set()
        while queue:
            i, j, si, sj = queue.pop(0)
            if i >= m or j >= n or k < si + sj or (i, j) in visited: continue
            visited.add((i,j))
            queue.append((i + 1, j, si + 1 if (i + 1) % 10 else si - 8, sj))
            queue.append((i, j + 1, si, sj + 1 if (j + 1) % 10 else sj - 8))
        return len(visited)

# ======= Test Case =======
m = 2
n = 3
k = 1
# ====== Driver Code ======
slt = Solution()
res = slt.movingCount(m, n, k)
print(res)
