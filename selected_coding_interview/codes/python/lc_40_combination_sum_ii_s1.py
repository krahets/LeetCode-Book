"""
File: lc_40_combination_sum_ii_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(
            state: list[int], target: int, choices: list[int], start: int, res: list[list[int]]
        ):
            """回溯算法：子集和 II"""
            # 子集和等于 target 时，记录解
            if target == 0:
                res.append(list(state))
                return
            # 遍历所有选择
            # 剪枝二：从 start 开始遍历，避免生成重复子集
            # 剪枝三：从 start 开始遍历，避免重复选择同一元素
            for i in range(start, len(choices)):
                # 剪枝一：若子集和超过 target ，则直接结束循环
                # 这是因为数组已排序，后边元素更大，子集和一定超过 target
                if target - choices[i] < 0:
                    break
                # 剪枝四：如果该元素与左边元素相等，说明该搜索分支重复，直接跳过
                if i > start and choices[i] == choices[i - 1]:
                    continue
                # 尝试：做出选择，更新 target, start
                state.append(choices[i])
                # 进行下一轮选择
                backtrack(state, target - choices[i], choices, i + 1, res)
                # 回退：撤销选择，恢复到之前的状态
                state.pop()
        state = []  # 状态（子集）
        candidates.sort()  # 对 candidates 进行排序
        start = 0  # 遍历起始点
        res = []  # 结果列表（子集列表）
        backtrack(state, target, candidates, start, res)
        return res


# ======= Test Case =======
test_input_candidates = [10, 1, 2, 7, 6, 1, 5]
test_input_target = 8
expected_output = [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

# ====== Driver Code ======
slt = Solution()
result = slt.combinationSum2(test_input_candidates, test_input_target)
print(result)
