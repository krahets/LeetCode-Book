/*
* File: sfo_03_find_duplicate_numbers_in_an_array_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        int i = 0;
        while(i < nums.size()) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i])
                return nums[i];
            swap(nums[i],nums[nums[i]]);
        }
        return -1;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 2, 3, 1, 0, 2, 5, 3 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->findRepeatNumber(nums);
    cout << res << endl;
    
    return 0;
}
