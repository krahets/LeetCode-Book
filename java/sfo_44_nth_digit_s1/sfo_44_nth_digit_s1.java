/*
* File: sfo_44_nth_digit_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_44_nth_digit_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}

public class sfo_44_nth_digit_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 3;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.findNthDigit(n);
        System.out.println(res);
    }
}
