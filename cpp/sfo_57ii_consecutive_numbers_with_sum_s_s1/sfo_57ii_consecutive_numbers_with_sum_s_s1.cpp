/*
* File: sfo_57ii_consecutive_numbers_with_sum_s_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<vector<int>> findContinuousSequence(int target) {
        int i = 1;
        double j = 2.0;
        vector<vector<int>> res;
        while(i < j) {
            j = (-1 + sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if(i < j && j == (int)j) {
                vector<int> ans;
                for(int k = i; k <= (int)j; k++)
                    ans.push_back(k);
                res.push_back(ans);
            }
            i++;
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
