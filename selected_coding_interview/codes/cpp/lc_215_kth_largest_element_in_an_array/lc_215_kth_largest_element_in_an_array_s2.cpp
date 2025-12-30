/*
 * File: lc_215_kth_largest_element_in_an_array_s2.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        return quickSort(nums, k, 0, nums.size() - 1);
    }
private:
    int quickSort(vector<int>& nums, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums[i], nums[j]);
        }
        swap(nums[i], nums[l]);
        if (i > nums.size() - k) return quickSort(nums, k, l, i - 1);
        if (i < nums.size() - k) return quickSort(nums, k, i + 1, r);
        // 若基准数索引为 n - k ，则直接返回该元素
        return nums[nums.size() - k];
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
