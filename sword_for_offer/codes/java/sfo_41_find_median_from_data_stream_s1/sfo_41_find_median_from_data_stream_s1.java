/*
* File: sfo_41_find_median_from_data_stream_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_41_find_median_from_data_stream_s1;

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
        if(A.size() != B.size()) {
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

public class sfo_41_find_median_from_data_stream_s1 {
    public static void main(String[] args) {
        // ====== Driver Code ======
        List<Double> res = new ArrayList<>();
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        res.add(medianFinder.findMedian());
        medianFinder.addNum(3);
        res.add(medianFinder.findMedian());
        System.out.println(Arrays.toString(res.toArray()));
    }
}
