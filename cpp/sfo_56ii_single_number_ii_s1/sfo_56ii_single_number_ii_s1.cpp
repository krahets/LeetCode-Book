/*
* File: sfo_56ii_single_number_ii_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 3, 4, 3, 3 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->singleNumber(nums);
    cout << res << endl;
    
    return 0;
}
