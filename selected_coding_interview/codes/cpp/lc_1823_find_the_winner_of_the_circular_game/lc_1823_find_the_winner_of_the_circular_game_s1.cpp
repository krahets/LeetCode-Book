/*
 * File: lc_1823_find_the_winner_of_the_circular_game_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int findTheWinner(int n, int k) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + k) % i;
        }
        return x + 1;
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
