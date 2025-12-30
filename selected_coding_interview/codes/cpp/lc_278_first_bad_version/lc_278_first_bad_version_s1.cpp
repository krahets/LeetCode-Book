/*
 * File: lc_278_first_bad_version_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int firstBadVersion(int n) {
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
};

int main() {
    // ======= Test Case =======
    // Note: You need to implement bool isBadVersion(int version) function

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->firstBadVersion(5);
    cout << res << endl;

    return 0;
}
