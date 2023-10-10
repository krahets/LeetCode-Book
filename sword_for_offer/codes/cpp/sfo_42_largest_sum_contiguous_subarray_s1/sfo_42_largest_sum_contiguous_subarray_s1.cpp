/*
* File: sfo_42_largest_sum_contiguous_subarray_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = nums[0];
        for(int i = 1; i < nums.size(); i++) {
            if(nums[i - 1] > 0) nums[i] += nums[i - 1];
            if(nums[i] > res) res = nums[i];
        }
        return res;  
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->maxSubArray(nums);
    cout << res << endl;
    
    return 0;
}
