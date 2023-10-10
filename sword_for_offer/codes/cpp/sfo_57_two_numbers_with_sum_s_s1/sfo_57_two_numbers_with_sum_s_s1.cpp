/*
* File: sfo_57_two_numbers_with_sum_s_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i = 0, j = nums.size() - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return { nums[i], nums[j] };
        }
        return {};
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 2, 7, 11, 15 };
    int target = 9;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->twoSum(nums, target);
    PrintUtil::printVector(res);
    
    return 0;
}
