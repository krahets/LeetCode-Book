/*
 * File: lc_154_find_minimum_in_rotated_sorted_array_ii_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int findMin(vector<int>& nums) {
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] > nums[j]) i = m + 1;
            else if (nums[m] < nums[j]) j = m;
            else {
                int x = i;
                for(int k = i + 1; k < j; k++) {
                    if(nums[k] < nums[x]) x = k;
                }
                return nums[x];
            }
        }
        return nums[i];
    }
};

int main() {
    // ======= Test Case =======
    // TODO: Add specific test case

    // ====== Driver Code ======
    Solution* slt = new Solution();
    // TODO: Call solution method and print result

    return 0;
}
