/*
* File: sfo_53ii_the_missing_number_from_0_to_n1_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int i = 0, j = nums.size() - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 0, 1, 3 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->missingNumber(nums);
    cout << res << endl;
    
    return 0;
}
