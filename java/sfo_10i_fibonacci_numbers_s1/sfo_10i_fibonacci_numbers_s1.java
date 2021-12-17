/*
* File: sfo_10i_fibonacci_numbers_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_10i_fibonacci_numbers_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}

public class sfo_10i_fibonacci_numbers_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 5;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.fib(n);
        System.out.println(res);
    }
}
