#!/usr/bin/env python3
"""
自动修复测试失败的 Python 文件
"""

import re
from pathlib import Path

def fix_missing_arguments():
    """修复缺少参数的测试用例"""

    fixes = {
        # 两个参数的函数
        'lc_10_regular_expression_matching': {
            'old': 'result = slt.isMatch(s)',
            'new': 'result = slt.isMatch("aa", "a*")'
        },
        'lc_105_construct_binary_tree_from_preorder_and_inorder_traversal': {
            'old': 'result = slt.buildTree(preorder)',
            'new': 'result = slt.buildTree([3,9,20,15,7], [9,3,15,20,7])'
        },
        'lc_113_path_sum_ii': {
            'old': 'result = slt.pathSum(root)',
            'new': 'result = slt.pathSum(root, 22)'
        },
        'lc_15_three_sum': {
            'old': 'result = slt.threeSum(nums)',
            'new': 'result = slt.threeSum([-1,0,1,2,-1,-4])'
        },
        'lc_167_two_sum_ii': {
            'old': 'result = slt.twoSum(numbers)',
            'new': 'result = slt.twoSum([2,7,11,15], 9)'
        },
        'lc_1823_find_the_winner_of_the_circular_game': {
            'old': 'result = slt.findTheWinner(n)',
            'new': 'result = slt.findTheWinner(5, 2)'
        },
        'lc_215_kth_largest_element_in_an_array': {
            'old': 'result = slt.findKthLargest(nums)',
            'new': 'result = slt.findKthLargest([3,2,1,5,6,4], 2)'
        },
        'lc_230_kth_smallest_element_in_a_bst': {
            'old': 'result = slt.kthSmallest(root)',
            'new': 'result = slt.kthSmallest(root, 3)'
        },
        'lc_233_number_of_digit_one': {
            'old': 'slt.countDigitOne(n)',
            'new': 'slt.countDigitOne(13)'
        },
        'lc_235_lowest_common_ancestor_of_a_binary_search_tree': {
            'old': 'result = slt.lowestCommonAncestor(root)',
            'new': 'result = slt.lowestCommonAncestor(root, root.left, root.right)'
        },
        'lc_236_lowest_common_ancestor_of_a_binary_tree': {
            'old': 'result = slt.lowestCommonAncestor(root)',
            'new': 'result = slt.lowestCommonAncestor(root, root.left, root.right)'
        },
        'lc_239_sliding_window_maximum': {
            'old': 'result = slt.maxSlidingWindow(nums)',
            'new': 'result = slt.maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3)'
        },
        'lc_240_search_a_2d_matrix_ii': {
            'old': 'result = slt.searchMatrix(matrix)',
            'new': 'result = slt.searchMatrix([[1,4,7,11,15],[2,5,8,12,19]], 5)'
        },
        'lc_242_valid_anagram': {
            'old': 'result = slt.isAnagram(s)',
            'new': 'result = slt.isAnagram("anagram", "nagaram")'
        },
        'lc_392_is_subsequence': {
            'old': 'result = slt.isSubsequence(s)',
            'new': 'result = slt.isSubsequence("abc", "ahbgdc")'
        },
        'lc_39_combination_sum': {
            'old': 'result = slt.combinationSum(candidates)',
            'new': 'result = slt.combinationSum([2,3,6,7], 7)'
        },
        'lc_40_combination_sum_ii': {
            'old': 'result = slt.combinationSum2(candidates)',
            'new': 'result = slt.combinationSum2([10,1,2,7,6,1,5], 8)'
        },
        'lc_415_add_strings': {
            'old': 'result = slt.addStrings(num1)',
            'new': 'result = slt.addStrings("11", "123")'
        },
        'lc_6_zigzag_conversion': {
            'old': 'result = slt.convert(s)',
            'new': 'result = slt.convert("PAYPALISHIRING", 3)'
        },
        'lc_704_binary_search': {
            'old': 'result = slt.search(nums)',
            'new': 'result = slt.search([-1,0,3,5,9,12], 9)'
        },
        'lc_796_rotate_string': {
            'old': 'result = slt.rotateString(s)',
            'new': 'result = slt.rotateString("abcde", "cdeab")'
        },
        'lc_79_word_search': {
            'old': 'result = slt.exist(board)',
            'new': 'result = slt.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED")'
        },
        'lc_86_partition_list': {
            'old': 'result = slt.partition(head)',
            'new': 'result = slt.partition(head, 3)'
        },
        'lc_946_validate_stack_sequences': {
            'old': 'result = slt.validateStackSequences(pushed)',
            'new': 'result = slt.validateStackSequences([1,2,3,4,5], [4,5,3,2,1])'
        },
    }

    current_dir = Path(__file__).parent
    fixed_count = 0

    for pattern, fix in fixes.items():
        # 查找所有匹配的文件
        files = list(current_dir.glob(f"{pattern}*.py"))

        for file_path in files:
            content = file_path.read_text()

            if fix['old'] in content:
                new_content = content.replace(fix['old'], fix['new'])
                file_path.write_text(new_content)
                print(f"✅ 修复: {file_path.name}")
                fixed_count += 1

    print(f"\n共修复 {fixed_count} 个文件")

if __name__ == "__main__":
    fix_missing_arguments()
