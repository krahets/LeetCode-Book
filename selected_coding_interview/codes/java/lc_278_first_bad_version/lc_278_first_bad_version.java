/*
* File: lc_278_first_bad_version.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_278_first_bad_version;

import include.*;
import java.util.*;

// ===== Solution Code =====
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int i = 1, j = n;
            while (i <= j) {
                // 向下取整除法计算中点 m 
                int m = i + (j - i) / 2;
                // 若 m 是错误版本，则最后一个正确版本一定在闭区间 [i, m - 1]
                if (isBadVersion(m)) j = m - 1;
                // 若 m 是正确版本，则首个错误版本一定在闭区间 [m + 1, j]
                else i = m + 1;
            }
            // i 指向首个错误版本，j 指向最后一个正确版本
            return i;
        }
    }

public class lc_278_first_bad_version {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.firstBadVersion(...)
        // print(result)

    }
}
