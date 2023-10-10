/*
* File: sfo_47_the_maximum_value_of_gifts_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_47_the_maximum_value_of_gifts_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }
}

public class sfo_47_the_maximum_value_of_gifts_s2 {
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
