"""
File: lc_1823_find_the_winner_of_the_circular_game.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        x = 0
        for i in range(2, n + 1):
            x = (x + k) % i
        return x + 1


# ======= Test Case =======
# Test case 1
# TODO: Add appropriate test case

# ====== Driver Code ======
slt = Solution()
# result = slt.findTheWinner(...)
# print(result)
