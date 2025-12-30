/*
 * File: lc_179_largest_number_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> strs;
        string res;
        for (int i = 0; i < nums.size(); i++)
            strs.push_back(to_string(nums[i]));
        sort(strs.begin(), strs.end(), [](string& x, string& y){ return y + x < x + y; });
        if (strs[0] == "0")
            return "0";
        for (int i = 0; i < strs.size(); i++)
            res.append(strs[i]);
        return res;
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
