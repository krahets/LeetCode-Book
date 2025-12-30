/*
* File: lc_48_rotate_image_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_48_rotate_image;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 深拷贝 matrix -> tmp
            int[][] tmp = new int[n][];
            for (int i = 0; i < n; i++)
                tmp[i] = matrix[i].clone();
            // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][n - 1 - i] = tmp[i][j];
                }
            }
        }
    }

public class lc_48_rotate_image_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[][] test_input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected_output = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};

        // ====== Driver Code ======
        Solution slt = new Solution();
        slt.rotate(test_input);
        PrintUtil.printMatrix(test_input);

    }
}
