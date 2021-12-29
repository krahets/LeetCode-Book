/*
* File: sfo_21_adjust_the_order_of_numbers_in_an_array_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> exchange(vector<int>& nums) {
        int i = 0, j = nums.size() - 1;
        while (i < j)
        {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            swap(nums[i], nums[j]);
        }
        return nums;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 1, 2, 3, 4 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->exchange(nums);
    PrintUtil::printVector(res);
    
    return 0;
}
