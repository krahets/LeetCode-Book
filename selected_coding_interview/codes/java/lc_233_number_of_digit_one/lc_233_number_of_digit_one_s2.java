/*
* File: lc_233_number_of_digit_one_s2.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_233_number_of_digit_one;

import include.*;
import java.util.*;

// ===== Solution Code =====
    while (high != 0 || cur != 0) { // 当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
        low += cur * digit; // 将 cur 加入 low ，组成下轮 low
        cur = high % 10; // 下轮 cur 是本轮 high 的最低位
        high /= 10; // 将本轮 high 最低位删除，得到下轮 high
        digit *= 10; // 位因子每轮 × 10
    }

public class lc_233_number_of_digit_one_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int test_input = 12;
        int expected_output = 5;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.countDigitOne(test_input);
        System.out.println(result);

    }
}
