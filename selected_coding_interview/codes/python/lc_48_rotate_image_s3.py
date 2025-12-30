"""
File: lc_48_rotate_image_s3.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        # 设矩阵行列数为 n
        n = len(matrix)
        # 起始点范围为 0 <= i < n // 2 , 0 <= j < (n + 1) // 2
        # 其中 '//' 为整数除法
        for i in range(n // 2):
            for j in range((n + 1) // 2):
                # 暂存 A 至 tmp
                tmp = matrix[i][j]
                # 元素旋转操作 A <- D <- C <- B <- tmp
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = tmp


# ======= Test Case =======
test_input = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
expected_output = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

# ====== Driver Code ======
slt = Solution()
slt.rotate(test_input)
print_matrix(test_input)
