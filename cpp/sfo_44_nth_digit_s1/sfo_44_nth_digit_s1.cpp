/*
* File: sfo_44_nth_digit_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int findNthDigit(int n) {
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
        return to_string(num)[(n - 1) % digit] - '0'; // 3.
    }
};

int main() {
    // ======= Test Case =======
    int n = 3;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->findNthDigit(n);
    cout << res << endl;
    
    return 0;
}
