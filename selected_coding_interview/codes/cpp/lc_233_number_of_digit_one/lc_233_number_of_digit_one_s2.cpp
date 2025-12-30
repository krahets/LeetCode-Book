/*
 * File: lc_233_number_of_digit_one_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
while (high != 0 || cur != 0) { // 当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
    low += cur * digit; // 将 cur 加入 low ，组成下轮 low
    cur = high % 10; // 下轮 cur 是本轮 high 的最低位
    high /= 10; // 将本轮 high 最低位删除，得到下轮 high
    digit *= 10; // 位因子每轮 × 10
}

int main() {
    // ======= Test Case =======
    // TODO: Add specific test case

    // ====== Driver Code ======
    Solution* slt = new Solution();
    // TODO: Call solution method and print result

    return 0;
}
