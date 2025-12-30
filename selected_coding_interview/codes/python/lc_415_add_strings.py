"""
File: lc_415_add_strings.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        res = ""
        i, j, carry = len(num1) - 1, len(num2) - 1, 0
        while i >= 0 or j >= 0:
            n1 = int(num1[i]) if i >= 0 else 0
            n2 = int(num2[j]) if j >= 0 else 0
            tmp = n1 + n2 + carry
            carry = tmp // 10
            res = str(tmp % 10) + res
            i, j = i - 1, j - 1
        return "1" + res if carry else res


# ======= Test Case =======
test_input_num1 = "11"
test_input_num2 = "123"
expected_output = "134"

# ====== Driver Code ======
slt = Solution()
result = slt.addStrings(test_input_num1, test_input_num2)
print(result)
