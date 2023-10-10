/*
* File: sfo_39_the_majority_element_in_an_array_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums)
            if(num == x) count++;
        return count > nums.size() / 2 ? x : 0; // 当无众数时返回 0
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->majorityElement(nums);
    cout << res << endl;
    
    return 0;
}
