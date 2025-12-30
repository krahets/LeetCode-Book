/*
 * File: lc_136_single_number_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int x = 0;
        for (int num : nums)  // 1. 遍历 nums 执行异或运算
            x ^= num;
        return x;            // 2. 返回出现一次的数字 x
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = {2, 2, 1};

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->singleNumber(nums);
    cout << res << endl;

    return 0;
}
