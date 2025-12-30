/*
 * File: lc_46_permutations_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        dfs(nums, 0);
        return res;
    }
private:
    vector<vector<int>> res;
    void dfs(vector<int> nums, int x) {
        if (x == nums.size() - 1) {
            res.push_back(nums);      // 添加排列方案
            return;
        }
        for (int i = x; i < nums.size(); i++) {
            swap(nums[i], nums[x]);   // 交换，将 nums[i] 固定在第 x 位
            dfs(nums, x + 1);         // 开启固定第 x + 1 位元素
            swap(nums[i], nums[x]);   // 恢复交换
        }
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = {1, 2, 3};

    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<vector<int>> res = slt->permute(nums);
    PrintUtil::printVectorMatrix(res);

    return 0;
}
