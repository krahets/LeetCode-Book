/*
 * File: lc_239_sliding_window_maximum_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        if(nums.size() == 0 || k == 0) return {};
        deque<int> deque;
        vector<int> res(nums.size() - k + 1);
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.empty() && deque.back() < nums[i])
                deque.pop_back();
            deque.push_back(nums[i]);
        }
        res[0] = deque.front();
        // 形成窗口后
        for(int i = k; i < nums.size(); i++) {
            if(deque.front() == nums[i - k])
                deque.pop_front();
            while(!deque.empty() && deque.back() < nums[i])
                deque.pop_back();
            deque.push_back(nums[i]);
            res[i - k + 1] = deque.front();
        }
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
