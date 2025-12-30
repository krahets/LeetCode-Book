/*
* File: lc_6_zigzag_conversion.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_6_zigzag_conversion;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public String convert(String s, int numRows) {
            if(numRows < 2) return s;
            List<StringBuilder> rows = new ArrayList<StringBuilder>();
            for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
            int i = 0, flag = -1;
            for(char c : s.toCharArray()) {
                rows.get(i).append(c);
                if(i == 0 || i == numRows -1) flag = - flag;
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for(StringBuilder row : rows) res.append(row);
            return res.toString();
        }
    }

public class lc_6_zigzag_conversion {
    public static void main(String[] args) {
        // ======= Test Case =======
        String test_input_s = "PAYPALISHIRING";
        int test_input_numRows = 3;
        String expected_output = "PAHNAPLSIIGYIR";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.convert(test_input_s, test_input_numRows);
        System.out.println(result);

    }
}
