/*
* File: sfo_61_straight_in_poker_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool isStraight(vector<int>& nums) {
        unordered_set<int> repeat;
        int ma = 0, mi = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            ma = max(ma, num); // 最大牌
            mi = min(mi, num); // 最小牌
            if(repeat.find(num) != repeat.end()) return false; // 若有重复，提前返回 false
            repeat.insert(num); // 添加此牌至 Set
        }
        return ma - mi < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
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
