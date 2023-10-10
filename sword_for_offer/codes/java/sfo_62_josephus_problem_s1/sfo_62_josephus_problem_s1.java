/*
* File: sfo_62_josephus_problem_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_62_josephus_problem_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}

public class sfo_62_josephus_problem_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 5;
        int m = 3;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.lastRemaining(n, m);
        System.out.println(res);
    }
}
