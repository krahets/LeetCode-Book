/*
* File: sfo_17_print_from_1_to_the_largest_n_digits_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_17_print_from_1_to_the_largest_n_digits_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }
}

public class sfo_17_print_from_1_to_the_largest_n_digits_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 1;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.printNumbers(n);
        System.out.println(Arrays.toString(res));
    }
}
