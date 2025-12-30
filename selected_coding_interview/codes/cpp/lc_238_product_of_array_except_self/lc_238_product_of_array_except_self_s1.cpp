/*
 * File: lc_238_product_of_array_except_self_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int len = nums.size();
        if (len == 0) return {};
        vector<int> ans(len, 1);
        ans[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }
        return ans;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = {1, 2, 3, 4};

    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->productExceptSelf(nums);
    PrintUtil::printVector(res);

    return 0;
}
