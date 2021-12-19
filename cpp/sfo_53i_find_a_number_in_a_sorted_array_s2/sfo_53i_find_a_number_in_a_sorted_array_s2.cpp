/*
* File: sfo_53i_find_a_number_in_a_sorted_array_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int search(vector<int>& nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
private:
    int helper(vector<int>& nums, int tar) {
        int i = 0, j = nums.size() - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 5, 7, 7, 8, 8, 10 };
    int target = 8;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->search(nums, target);
    cout << res << endl;
    
    return 0;
}
