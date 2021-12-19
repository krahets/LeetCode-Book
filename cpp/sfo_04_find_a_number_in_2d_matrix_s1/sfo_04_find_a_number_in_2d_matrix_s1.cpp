/*
* File: sfo_04_find_a_number_in_2d_matrix_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool findNumberIn2DArray(vector<vector<int>>& matrix, int target) {
        int i = matrix.size() - 1, j = 0;
        while(i >= 0 && j < matrix[0].size())
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
};

int main() {
    // ======= Test Case =======
    vector<vector<int>> matrix = {
    { 1, 4, 7, 11, 15 },
    { 2, 5, 8, 12, 19 },
    { 3, 6, 9, 16, 22 },
    { 10, 13, 14, 17, 24 },
    { 18, 21, 23, 26, 30 }
};
    int target = 5;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->findNumberIn2DArray(matrix, target);
    cout << boolalpha << res << endl;
    
    return 0;
}
