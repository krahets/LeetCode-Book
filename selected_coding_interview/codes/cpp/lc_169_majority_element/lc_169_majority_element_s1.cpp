/*
 * File: lc_169_majority_element_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = {3, 2, 3};

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->majorityElement(nums);
    cout << res << endl;

    return 0;
}
