/*
* File: sfo_29_print_a_given_matrix_in_spiral_form_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_29_print_a_given_matrix_in_spiral_form_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top
            if(++l > r) break;
        }
        return res;
    }
}

public class sfo_29_print_a_given_matrix_in_spiral_form_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[][] matrix = {
    { 1, 2, 3 },
    { 4, 5, 6 },
    { 7, 8, 9 }
};
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.spiralOrder(matrix);
        System.out.println(Arrays.toString(res));
    }
}
