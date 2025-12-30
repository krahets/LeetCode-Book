/*
* File: lc_64_minimum_path_sum.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_64_minimum_path_sum;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int minPathSum(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(i == 0 && j == 0) continue;
                    else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                    else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                    else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }

public class lc_64_minimum_path_sum {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.minPathSum(...)
        // print(result)

    }
}
