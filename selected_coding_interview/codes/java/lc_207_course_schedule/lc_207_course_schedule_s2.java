/*
* File: lc_207_course_schedule_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_207_course_schedule;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjacency = new ArrayList<>();
            for(int i = 0; i < numCourses; i++)
                adjacency.add(new ArrayList<>());
            int[] flags = new int[numCourses];
            for(int[] cp : prerequisites)
                adjacency.get(cp[1]).add(cp[0]);
            for(int i = 0; i < numCourses; i++)
                if(!dfs(adjacency, flags, i)) return false;
            return true;
        }
        private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
            if(flags[i] == 1) return false;
            if(flags[i] == -1) return true;
            flags[i] = 1;
            for(Integer j : adjacency.get(i))
                if(!dfs(adjacency, flags, j)) return false;
            flags[i] = -1;
            return true;
        }
    }

public class lc_207_course_schedule_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int test_input_numCourses = 2;
        int[][] test_input_prerequisites = new int[][]{{1, 0}};
        var expected_output = true;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.canFinish(test_input_numCourses, test_input_prerequisites);
        System.out.println(result);

    }
}
