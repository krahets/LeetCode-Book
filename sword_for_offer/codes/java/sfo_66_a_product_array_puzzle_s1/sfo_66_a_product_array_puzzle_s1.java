/*
* File: sfo_66_a_product_array_puzzle_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_66_a_product_array_puzzle_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}

public class sfo_66_a_product_array_puzzle_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] a = { 1, 2, 3, 4, 5 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.constructArr(a);
        System.out.println(Arrays.toString(res));
    }
}
