/*
* File: lc_48_rotate_image_s2.java
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
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = tmp;
                }
            }
        }
    }

public class lc_48_rotate_image_s2 {
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
