/*
* File: lc_1823_find_the_winner_of_the_circular_game.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_1823_find_the_winner_of_the_circular_game;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int findTheWinner(int n, int k) {
            int x = 0;
            for (int i = 2; i <= n; i++) {
                x = (x + k) % i;
            }
            return x + 1;
        }
    }

public class lc_1823_find_the_winner_of_the_circular_game {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.findTheWinner(...)
        // print(result)

    }
}
