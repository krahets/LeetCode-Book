/*
* File: sfo_56i_single_number_i_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> singleNumbers(vector<int>& nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums)         // 1. 遍历异或
            n ^= num;
        while((n & m) == 0)         // 2. 循环左移，计算 m
            m <<= 1;
        for(int num : nums) {       // 3. 遍历 nums 分组
            if(num & m) x ^= num;   // 4. 当 num & m != 0
            else y ^= num;          // 4. 当 num & m == 0
        }
        return vector<int> {x, y};  // 5. 返回出现一次的数字
    }
};

int main() {
    // ======= Test Case =======
    vector<int> nums = { 4, 1, 4, 6 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->singleNumbers(nums);
    PrintUtil::printVector(res);
    
    return 0;
}
