/*
* File: sfo_13_range_of_motion_of_a_robot_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_13_range_of_motion_of_a_robot_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}

public class sfo_13_range_of_motion_of_a_robot_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int m = 2;
        int n = 3;
        int k = 1;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.movingCount(m, n, k);
        System.out.println(res);
    }
}
