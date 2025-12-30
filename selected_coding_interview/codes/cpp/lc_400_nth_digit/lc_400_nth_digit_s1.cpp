/*
 * File: lc_400_nth_digit_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
int digit = 1;
long start = 1;
long count = 9;
while (n > count) { // 1.
   n -= count;
   start *= 10; // 1, 10, 100, ...
   digit += 1;  // 1,  2,  3, ...
   count = digit * start * 9; // 9, 180, 2700, ...
}

int main() {
    // ======= Test Case =======
    // TODO: Add specific test case

    // ====== Driver Code ======
    Solution* slt = new Solution();
    // TODO: Call solution method and print result

    return 0;
}
