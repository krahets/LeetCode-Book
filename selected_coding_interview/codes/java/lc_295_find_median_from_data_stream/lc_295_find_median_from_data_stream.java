/*
* File: lc_295_find_median_from_data_stream.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_295_find_median_from_data_stream;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class MedianFinder {
        Queue<Integer> A, B;
        public MedianFinder() {
            A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
        }
        public void addNum(int num) {
            if (A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }
        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }

public class lc_295_find_median_from_data_stream {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test Case: Add appropriate test case here
        Solution slt = new Solution();
        // Call solution method and print result
        System.out.println("Test completed");
    }
}
