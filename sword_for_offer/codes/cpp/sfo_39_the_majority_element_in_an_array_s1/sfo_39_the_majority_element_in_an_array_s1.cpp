/*
* File: sfo_39_the_majority_element_in_an_array_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
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
