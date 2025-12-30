"""
File: lc_796_rotate_string.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        return len(s) == len(goal) and s in (goal + goal)


# ======= Test Case =======
test_input_s = "abcde"
test_input_goal = "cdeab"
expected_output = True

# ====== Driver Code ======
slt = Solution()
result = slt.rotateString(test_input_s, test_input_goal)
print(result)
