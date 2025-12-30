/*
* File: lc_509_fibonacci_number.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_509_fibonacci_number;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int fib(int n) {
            int a = 0, b = 1, sum;
            for(int i = 0; i < n; i++){
                sum = a + b;
                a = b;
                b = sum;
            }
            return a;
        }
    }

public class lc_509_fibonacci_number {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.fib(...)
        // print(result)

    }
}
