/*
* File: sfo_13_range_of_motion_of_a_robot_s2.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int movingCount(int m, int n, int k) {
        vector<vector<bool>> visited(m, vector<bool>(n, 0));
        int res = 0;
        queue<vector<int>> que;
        que.push({ 0, 0, 0, 0 });
        while(que.size() > 0) {
            vector<int> x = que.front();
            que.pop();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            que.push({ i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            que.push({ i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }
};

int main() {
    // ======= Test Case =======
    int m = 2;
    int n = 3;
    int k = 1;
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->movingCount(m, n, k);
    cout << res << endl;
    
    return 0;
}
