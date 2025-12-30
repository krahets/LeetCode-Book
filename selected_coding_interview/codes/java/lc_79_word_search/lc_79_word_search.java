/*
* File: lc_79_word_search.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_79_word_search;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if (dfs(board, words, i, j, 0)) return true;
                }
            }
            return false;
        }
        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
            if (k == word.length - 1) return true;
            board[i][j] = '\0';
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || 
                          dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
            board[i][j] = word[k];
            return res;
        }
    }

public class lc_79_word_search {
    public static void main(String[] args) {
        // ======= Test Case =======
        String[][] test_input_board = new String[][]{{"A","B","C","E"}, {"S","F","C","S"}, {"A","D","E","E"}};
        String test_input_word = "ABCCED";
        var expected_output = true;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.exist(test_input_board, test_input_word);
        System.out.println(result);

    }
}
