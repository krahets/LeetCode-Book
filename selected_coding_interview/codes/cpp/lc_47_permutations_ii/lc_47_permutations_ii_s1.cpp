/*
 * File: lc_47_permutations_ii_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
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
        set<int> st;
        for (int i = x; i < nums.size(); i++) {
            if (st.find(nums[i]) != st.end())
                continue;             // 重复，因此剪枝
            st.insert(nums[i]);
            swap(nums[i], nums[x]);   // 交换，将 nums[i] 固定在第 x 位
            dfs(nums, x + 1);         // 开启固定第 x + 1 位元素
            swap(nums[i], nums[x]);   // 恢复交换
        }
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
