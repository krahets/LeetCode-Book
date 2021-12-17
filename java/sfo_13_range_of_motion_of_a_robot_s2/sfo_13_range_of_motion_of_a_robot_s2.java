/*
* File: sfo_13_range_of_motion_of_a_robot_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_13_range_of_motion_of_a_robot_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<int[]>();
        queue.add(new int[] { 0, 0, 0, 0 });
        while(queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res ++;
            queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }
}

public class sfo_13_range_of_motion_of_a_robot_s2 {
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
