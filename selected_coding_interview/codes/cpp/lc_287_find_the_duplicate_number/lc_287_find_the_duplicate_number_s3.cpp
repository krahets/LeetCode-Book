/*
 * File: lc_287_find_the_duplicate_number_s3.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> nums;
    int next(int index) {
        // 直接返回当前索引处的值作为下一个索引
        return nums[index];
    }
    int findDuplicate(vector<int>& nums) {
        this->nums = nums;
        int slow = 0;
        int fast = 0;
        // 第一次相遇
        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);
        slow = 0;
        // 第二次相遇
        while (slow != fast) {
            slow = next(slow);
            fast = next(fast);
        }
        return slow;
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
