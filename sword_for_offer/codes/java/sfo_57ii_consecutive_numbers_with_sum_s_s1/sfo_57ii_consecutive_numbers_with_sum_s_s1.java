/*
* File: sfo_57ii_consecutive_numbers_with_sum_s_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_57ii_consecutive_numbers_with_sum_s_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if(i < j && j == (int)j) {
                int[] ans = new int[(int)j - i + 1];
                for(int k = i; k <= (int)j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }
}

public class sfo_57ii_consecutive_numbers_with_sum_s_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int target = 9;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[][] res = slt.findContinuousSequence(target);
        System.out.println(Arrays.deepToString(res));
    }
}
