/*
* File: sfo_61_straight_in_poker_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool isStraight(vector<int>& nums) {
        int joker = 0;
        sort(nums.begin(), nums.end()); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 0, 0, 1, 2, 5 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->isStraight(nums);
    cout << boolalpha << res << endl;
    
    return 0;
}
