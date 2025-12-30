/*
* File: lc_59_spiral_matrix.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_59_spiral_matrix;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int[][] generateMatrix(int n) {
            int l = 0, r = n - 1, t = 0, b = n - 1;
            int[][] mat = new int[n][n];
            int num = 1, tar = n * n;
            while(num <= tar){
                for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
                t++;
                for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
                r--;
                for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
                b--;
                for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
                l++;
            }
            return mat;
        }
    }

public class lc_59_spiral_matrix {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.generateMatrix(...)
        // print(result)

    }
}
