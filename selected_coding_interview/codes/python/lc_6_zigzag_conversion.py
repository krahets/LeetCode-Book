"""
File: lc_6_zigzag_conversion.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows < 2: return s
        res = ["" for _ in range(numRows)]
        i, flag = 0, -1
        for c in s:
            res[i] += c
            if i == 0 or i == numRows - 1: flag = -flag
            i += flag
        return "".join(res)


# ======= Test Case =======
test_input_s = "PAYPALISHIRING"
test_input_numRows = 3
expected_output = "PAHNAPLSIIGYIR"

# ====== Driver Code ======
slt = Solution()
result = slt.convert(test_input_s, test_input_numRows)
print(result)
