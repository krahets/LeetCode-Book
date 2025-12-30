/*
 * File: lc_1480_running_sum_of_1d_array_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        vector<int> dp(nums.size());
        dp[0] = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = {1, 2, 3, 4};

    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->runningSum(nums);
    PrintUtil::printVector(res);

    return 0;
}
