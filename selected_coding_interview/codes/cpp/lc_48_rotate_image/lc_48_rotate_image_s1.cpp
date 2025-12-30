/*
 * File: lc_48_rotate_image_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        // 深拷贝 matrix -> tmp
        vector<vector<int>> tmp = matrix;
        // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
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
