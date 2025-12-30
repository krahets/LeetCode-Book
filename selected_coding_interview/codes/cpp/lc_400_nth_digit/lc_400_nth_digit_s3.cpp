/*
 * File: lc_400_nth_digit_s3.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
string s = to_string(num); // 转化为 string
int res = s[(n - 1) % digit] - '0'; // 获得 num 的 第 (n - 1) % digit 个数位，并转化为 int

int main() {
    // ======= Test Case =======
    // TODO: Add specific test case

    // ====== Driver Code ======
    Solution* slt = new Solution();
    // TODO: Call solution method and print result

    return 0;
}
