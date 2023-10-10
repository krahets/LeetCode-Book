/*
* File: sfo_03_find_duplicate_numbers_in_an_array_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        unordered_map<int, bool> map;
        for(int num : nums) {
            if(map[num]) return num;
            map[num] = true;
        }
        return -1;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 2, 3, 1, 0, 2, 5, 3 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->findRepeatNumber(nums);
    cout << res << endl;
    
    return 0;
}
