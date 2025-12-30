/*
 * File: lc_167_two_sum_ii_input_array_is_sorted_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int i = 0, j = numbers.size() - 1;
        while (i < j) {
            int s = numbers[i] + numbers[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return { i + 1, j + 1 };
        }
        return {};
    }
};

int main() {
    // ======= Test Case =======
    vector<int> numbers = {2, 7, 11, 15};
    int target = 9;

    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->twoSum(numbers, target);
    PrintUtil::printVector(res);

    return 0;
}
