/*
* File: sfo_41_find_median_from_data_stream_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class MedianFinder {
public:
    priority_queue<int, vector<int>, greater<int>> A; // 小顶堆，保存较大的一半
    priority_queue<int, vector<int>, less<int>> B; // 大顶堆，保存较小的一半
    MedianFinder() { }
    void addNum(int num) {
        if(A.size() != B.size()) {
            A.push(num);
            B.push(A.top());
            A.pop();
        } else {
            B.push(num);
            A.push(B.top());
            B.pop();
        }
    }
    double findMedian() {
        return A.size() != B.size() ? A.top() : (A.top() + B.top()) / 2.0;
    }
};

int main() {
    // ====== Driver Code ======
    vector<double> res;
    MedianFinder* medianFinder = new MedianFinder();
    medianFinder->addNum(1);
    medianFinder->addNum(2);
    res.push_back(medianFinder->findMedian());
    medianFinder->addNum(3);
    res.push_back(medianFinder->findMedian());
    PrintUtil::printVector(res);

    return 0;
}