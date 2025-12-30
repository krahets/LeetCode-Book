"""
File: lc_392_is_subsequence.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s: return True
        i = 0
        for c in t:
            if s[i] == c:
                i += 1
                # 若已经遍历完 s ，则提前返回 true
                if i == len(s):
                    return True
        return False


# ======= Test Case =======
test_input_s = "abc"
test_input_t = "ahbgdc"
expected_output = True

# ====== Driver Code ======
slt = Solution()
result = slt.isSubsequence(test_input_s, test_input_t)
print(result)
