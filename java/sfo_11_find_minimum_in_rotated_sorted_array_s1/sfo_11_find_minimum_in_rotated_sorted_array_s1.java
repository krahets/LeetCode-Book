/*
* File: sfo_11_find_minimum_in_rotated_sorted_array_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_11_find_minimum_in_rotated_sorted_array_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}

public class sfo_11_find_minimum_in_rotated_sorted_array_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] numbers = { 3, 4, 5, 1, 2 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.minArray(numbers);
        System.out.println(res);
    }
}
