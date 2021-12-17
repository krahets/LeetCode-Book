/*
* File: sfo_40_the_smallest_k_numbers_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_40_the_smallest_k_numbers_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }
    private void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

public class sfo_40_the_smallest_k_numbers_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] arr = { 3, 2, 1 };
        int k = 2;
        // ====== Driver Code ======
        Solution slt = new Solution();
        int[] res = slt.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
