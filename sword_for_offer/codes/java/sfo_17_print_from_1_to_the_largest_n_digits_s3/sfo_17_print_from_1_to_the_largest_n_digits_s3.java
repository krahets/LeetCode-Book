/*
* File: sfo_17_print_from_1_to_the_largest_n_digits_s3.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_17_print_from_1_to_the_largest_n_digits_s3;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res.append(s + ",");
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}

public class sfo_17_print_from_1_to_the_largest_n_digits_s3 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 1;
        // ====== Driver Code ======
        Solution slt = new Solution();
        String res = slt.printNumbers(n);
        System.out.println(res);
    }
}
