/*
* File: sfo_11_find_minimum_in_rotated_sorted_array_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int minArray(vector<int>& numbers) {
        int i = 0, j = numbers.size() - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
};

int main() {
    // ======= Test Case =======
    vector<int> numbers = { 3, 4, 5, 1, 2 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->minArray(numbers);
    cout << res << endl;
    
    return 0;
}
