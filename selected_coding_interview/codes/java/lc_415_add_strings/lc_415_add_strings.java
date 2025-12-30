/*
* File: lc_415_add_strings.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_415_add_strings;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder("");
            int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
            while(i >= 0 || j >= 0){
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int tmp = n1 + n2 + carry;
                carry = tmp / 10;
                res.append(tmp % 10);
                i--; j--;
            }
            if(carry == 1) res.append(1);
            return res.reverse().toString();
        }
    }

public class lc_415_add_strings {
    public static void main(String[] args) {
        // ======= Test Case =======
        String test_input_num1 = "11";
        String test_input_num2 = "123";
        String expected_output = "134";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.addStrings(test_input_num1, test_input_num2);
        System.out.println(result);

    }
}
