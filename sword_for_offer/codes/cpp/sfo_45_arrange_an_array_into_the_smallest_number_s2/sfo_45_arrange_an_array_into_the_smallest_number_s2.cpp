/*
* File: sfo_45_arrange_an_array_into_the_smallest_number_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    string minNumber(vector<int>& nums) {
        vector<string> strs;
        string res;
        for(int i = 0; i < nums.size(); i++)
            strs.push_back(to_string(nums[i]));
        sort(strs.begin(), strs.end(), [](string& x, string& y){ return x + y < y + x; });
        for(int i = 0; i < strs.size(); i++)
            res.append(strs[i]);
        return res;
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 3, 30, 34, 5, 9 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    string res = slt->minNumber(nums);
    cout << res << endl;
    
    return 0;
}
