"""
File: lc_167_two_sum_ii.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i, j = 0, len(numbers) - 1
        while i < j:
            s = numbers[i] + numbers[j]
            if s > target: j -= 1
            elif s < target: i += 1
            else: return i + 1, j + 1
        return []


# ======= Test Case =======
test_input_numbers = [2, 7, 11, 15]
test_input_target = 9
expected_output = [1, 2]

# ====== Driver Code ======
slt = Solution()
result = slt.twoSum(test_input_numbers, test_input_target)
print(result)
