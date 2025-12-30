/*
* File: lc_207_course_schedule_s1.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_207_course_schedule;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegrees = new int[numCourses];
            List<List<Integer>> adjacency = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++)
                adjacency.add(new ArrayList<>());
            // Get the indegree and adjacency of every course.
            for(int[] cp : prerequisites) {
                indegrees[cp[0]]++;
                adjacency.get(cp[1]).add(cp[0]);
            }
            // Get all the courses with the indegree of 0.
            for(int i = 0; i < numCourses; i++)
                if(indegrees[i] == 0) queue.add(i);
            // BFS TopSort.
            while(!queue.isEmpty()) {
                int pre = queue.poll();
                numCourses--;
                for(int cur : adjacency.get(pre))
                    if(--indegrees[cur] == 0) queue.add(cur);
            }
            return numCourses == 0;
        }
    }

public class lc_207_course_schedule_s1 {
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
