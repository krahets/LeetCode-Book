/*
 * File: lc_400_nth_digit_s4.cpp
 * Created Time: 2025-12-30
 * Author: krahets
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
    // TODO: Add specific test case

    // ====== Driver Code ======
    Solution* slt = new Solution();
    // TODO: Call solution method and print result

    return 0;
}
