/*
* File: sfo_57ii_consecutive_numbers_with_sum_s_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_57ii_consecutive_numbers_with_sum_s_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(s == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if(s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}

public class sfo_57ii_consecutive_numbers_with_sum_s_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int target = 9;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[][] res = slt.findContinuousSequence(target);
        System.out.println(Arrays.deepToString(res));
    }
}
