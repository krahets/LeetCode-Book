/*
* File: sfo_40_the_smallest_k_numbers_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_40_the_smallest_k_numbers_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }
    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort(arr, k, l, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

public class sfo_40_the_smallest_k_numbers_s2 {
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
