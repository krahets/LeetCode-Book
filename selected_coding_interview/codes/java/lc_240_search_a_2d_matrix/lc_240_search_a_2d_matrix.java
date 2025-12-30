/*
* File: lc_240_search_a_2d_matrix.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_240_search_a_2d_matrix;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int i = matrix.length - 1, j = 0;
            while(i >= 0 && j < matrix[0].length)
            {
                if(matrix[i][j] > target) i--;
                else if(matrix[i][j] < target) j++;
                else return true;
            }
            return false;
        }
    }

public class lc_240_search_a_2d_matrix {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[][] test_input_matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int test_input_target = 5;
        var expected_output = true;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.searchMatrix(test_input_matrix, test_input_target);
        System.out.println(result);

    }
}
