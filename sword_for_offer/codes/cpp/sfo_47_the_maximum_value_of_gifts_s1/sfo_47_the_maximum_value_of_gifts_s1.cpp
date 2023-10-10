/*
* File: sfo_47_the_maximum_value_of_gifts_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int maxValue(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j - 1] ;
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
};

int main() {
    // ======= Test Case =======
    vector<vector<int>> grid = {
    { 1, 3, 1 },
    { 1, 5, 1 },
    { 4, 2, 1 }
};
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->maxValue(grid);
    cout << res << endl;
    
    return 0;
}
