"""
File: lc_79_word_search.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(i, j, k):
            if not 0 <= i < len(board) or not 0 <= j < len(board[0]) or board[i][j] != word[k]: return False
            if k == len(word) - 1: return True
            board[i][j] = ''
            res = dfs(i + 1, j, k + 1) or dfs(i - 1, j, k + 1) or dfs(i, j + 1, k + 1) or dfs(i, j - 1, k + 1)
            board[i][j] = word[k]
            return res
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, 0): return True
        return False


# ======= Test Case =======
test_input_board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
test_input_word = "ABCCED"
expected_output = True

# ====== Driver Code ======
slt = Solution()
result = slt.exist(test_input_board, test_input_word)
print(result)
