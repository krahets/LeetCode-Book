/*
* File: lc_89_gray_code.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_89_gray_code;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
            int head = 1;
            for (int i = 0; i < n; i++) {
                for (int j = res.size() - 1; j >= 0; j--)
                    res.add(head + res.get(j));
                head <<= 1;
            }
            return res;
        }
    }

public class lc_89_gray_code {
    public static void main(String[] args) {
        // ======= Test Case =======
        int test_input = 2;
        int[] expected_output = new int[]{0, 1, 3, 2};

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.grayCode(test_input);
        System.out.println(result);

    }
}
