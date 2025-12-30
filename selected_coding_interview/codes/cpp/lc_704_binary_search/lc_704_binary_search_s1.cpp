/*
 * File: lc_704_binary_search_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int i = 0, j = nums.size() - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else if (nums[m] > target) j = m - 1;
            else return m;
        }
        return -1;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = {-1, 0, 3, 5, 9, 12};
    int target = 9;

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->search(nums, target);
    cout << res << endl;

    return 0;
}
