"""
File: lc_240_search_a_2d_matrix_ii.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        i, j = len(matrix) - 1, 0
        while i >= 0 and j < len(matrix[0]):
            if matrix[i][j] > target: i -= 1
            elif matrix[i][j] < target: j += 1
            else: return True
        return False


# ======= Test Case =======
test_input_matrix = [[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]]
test_input_target = 5
expected_output = True

# ====== Driver Code ======
slt = Solution()
result = slt.searchMatrix(test_input_matrix, test_input_target)
print(result)
