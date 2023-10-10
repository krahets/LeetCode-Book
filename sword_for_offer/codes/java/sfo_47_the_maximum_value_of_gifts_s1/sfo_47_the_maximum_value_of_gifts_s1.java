/*
* File: sfo_47_the_maximum_value_of_gifts_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_47_the_maximum_value_of_gifts_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j - 1] ;
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}

public class sfo_47_the_maximum_value_of_gifts_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[][] grid = {
    { 1, 3, 1 },
    { 1, 5, 1 },
    { 4, 2, 1 }
};
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.maxValue(grid);
        System.out.println(res);
    }
}
