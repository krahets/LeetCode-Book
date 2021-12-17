/*
* File: sfo_04_find_a_number_in_2d_matrix_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_04_find_a_number_in_2d_matrix_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
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

public class sfo_04_find_a_number_in_2d_matrix_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[][] matrix = {
            { 1, 4, 7, 11, 15 },
            { 2, 5, 8, 12, 19 },
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 },
            { 18, 21, 23, 26, 30 }
        };
        int target = 5;
        // ====== Driver Code ======
        Solution slt = new Solution();
        boolean res = slt.findNumberIn2DArray(matrix, target);
        System.out.println(res);
    }
}
