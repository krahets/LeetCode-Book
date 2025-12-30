/*
* File: lc_135_candy.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_135_candy;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int candy(int[] ratings) {
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);
            for(int i = 1; i < ratings.length; i++)
                if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
            int count = left[ratings.length - 1];
            for(int i = ratings.length - 2; i >= 0; i--) {
                if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
                count += Math.max(left[i], right[i]);
            }
            return count;
        }
    }

public class lc_135_candy {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        int[] test_input = new int[]{1, 2, 3, 4, 5};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.candy(test_input);
        System.out.println(result);

    }
}
