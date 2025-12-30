/*
 * File: lc_48_rotate_image_s3.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        // 设矩阵行列数为 n
        int n = matrix.size();
        // 起始点范围为 0 <= i < n / 2 , 0 <= j < (n + 1) / 2
        // 其中 '/' 为整数除法
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                // 暂存 A 至 tmp
                int tmp = matrix[i][j];
                // 元素旋转操作 A <- D <- C <- B <- tmp
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
};

int main() {
    // ======= Test Case =======
    vector<vector<int>> matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    // ====== Driver Code ======
    Solution* slt = new Solution();
    slt->rotate(matrix);
    PrintUtil::printVectorMatrix(matrix);

    return 0;
}
