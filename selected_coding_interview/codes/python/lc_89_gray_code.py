"""
File: lc_89_gray_code.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def grayCode(self, n: int) -> List[int]:
        res, head = [0], 1
        for i in range(n):
            for j in range(len(res) - 1, -1, -1):
                res.append(head + res[j])
            head <<= 1
        return res


# ======= Test Case =======
test_input = 2
expected_output = [0, 1, 3, 2]

# ====== Driver Code ======
slt = Solution()
result = slt.grayCode(test_input)
print(result)
