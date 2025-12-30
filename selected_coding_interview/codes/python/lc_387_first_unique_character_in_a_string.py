"""
File: lc_387_first_unique_character_in_a_string.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic = {}
        for c in s:
            dic[c] = not c in dic
        for i, c in enumerate(s):
            if dic[c]: return i
        return -1


# ======= Test Case =======
# Test case 1
test_input = "example"

# ====== Driver Code ======
slt = Solution()
result = slt.firstUniqChar(test_input)
print(result)
