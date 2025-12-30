/*
 * File: lc_724_find_pivot_index_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int sumLeft = 0, sumRight = accumulate(nums.begin(), nums.end(), 0);
        for (int i = 0; i < nums.size(); i++) {
            sumRight -= nums[i];
            // 若左侧元素和等于右侧元素和，返回中心下标 i
            if (sumLeft == sumRight)
                return i;
            sumLeft += nums[i];
        }
        return -1;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = {1, 7, 3, 6, 5, 6};

    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->pivotIndex(nums);
    cout << res << endl;

    return 0;
}
