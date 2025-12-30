"""
File: lc_48_rotate_image_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        # 深拷贝 matrix -> tmp
        tmp = copy.deepcopy(matrix)
        # 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
        for i in range(n):
            for j in range(n):
                matrix[j][n - 1 - i] = tmp[i][j]


# ======= Test Case =======
test_input = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
expected_output = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

# ====== Driver Code ======
slt = Solution()
slt.rotate(test_input)
print_matrix(test_input)
