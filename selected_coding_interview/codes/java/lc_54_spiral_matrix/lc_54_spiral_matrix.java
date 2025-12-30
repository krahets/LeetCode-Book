/*
* File: lc_54_spiral_matrix.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_54_spiral_matrix;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0)
                return new ArrayList<Integer>();
            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
            Integer[] res = new Integer[(r + 1) * (b + 1)];
            while (true) {
                for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right
                if (++t > b) break;
                for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom
                if (l > --r) break;
                for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left
                if (t > --b) break;
                for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top
                if (++l > r) break;
            }
            return Arrays.asList(res);
        }
    }

public class lc_54_spiral_matrix {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[][] test_input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] expected_output = new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.spiralOrder(test_input);
        System.out.println(result);

    }
}
