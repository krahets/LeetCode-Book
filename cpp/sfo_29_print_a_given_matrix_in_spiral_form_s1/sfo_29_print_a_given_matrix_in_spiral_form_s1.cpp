/*
* File: sfo_29_print_a_given_matrix_in_spiral_form_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if (matrix.empty()) return {};
        int l = 0, r = matrix[0].size() - 1, t = 0, b = matrix.size() - 1;
        vector<int> res;
        while(true)
        {
            for (int i = l; i <= r; i++) res.push_back(matrix[t][i]); // left to right
            if (++t > b) break;
            for (int i = t; i <= b; i++) res.push_back(matrix[i][r]); // top to bottom
            if (l > --r) break;
            for (int i = r; i >= l; i--) res.push_back(matrix[b][i]); // right to left
            if (t > --b) break;
            for (int i = b; i >= t; i--) res.push_back(matrix[i][l]); // bottom to top
            if (++l > r) break;
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    vector<vector<int>> matrix = {
    { 1, 2, 3 },
    { 4, 5, 6 },
    { 7, 8, 9 }
};
    // ====== Driver Code ======
    Solution* slt = new Solution();
    vector<int> res = slt->spiralOrder(matrix);
    PrintUtil::printVector(res);
    
    return 0;
}
