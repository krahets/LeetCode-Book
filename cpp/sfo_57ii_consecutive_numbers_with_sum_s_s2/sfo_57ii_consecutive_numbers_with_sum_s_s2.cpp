/*
* File: sfo_57ii_consecutive_numbers_with_sum_s_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        vector<vector<int>> res;
        while(i < j) {
            if(s == target) {
                vector<int> ans;
                for(int k = i; k <= j; k++)
                    ans.push_back(k);
                res.push_back(ans);
            }
            if(s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    int target = 9;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<vector<int>> res = slt->findContinuousSequence(target);
    PrintUtil::printVectorMatrix(res);
    
    return 0;
}
