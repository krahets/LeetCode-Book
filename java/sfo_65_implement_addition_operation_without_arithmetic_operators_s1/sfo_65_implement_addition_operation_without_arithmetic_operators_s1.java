/*
* File: sfo_65_implement_addition_operation_without_arithmetic_operators_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_65_implement_addition_operation_without_arithmetic_operators_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}

public class sfo_65_implement_addition_operation_without_arithmetic_operators_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int a = 1;
        int b = 1;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.add(a, b);
        System.out.println(res);
    }
}
