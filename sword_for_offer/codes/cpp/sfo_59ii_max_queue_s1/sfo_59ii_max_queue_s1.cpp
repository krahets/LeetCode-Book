/*
* File: sfo_59ii_max_queue_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class MaxQueue {
    queue<int> que;
    deque<int> deq;
public:
    MaxQueue() { }
    int max_value() {
        return deq.empty() ? -1 : deq.front();
    }
    void push_back(int value) {
        que.push(value);
        while(!deq.empty() && deq.back() < value)
            deq.pop_back();
        deq.push_back(value);
    }
    int pop_front() {
        if(que.empty()) return -1;
        int val = que.front();
        if(val == deq.front())
            deq.pop_front();
        que.pop();
        return val;
    }
};

int main() {
    // ====== Driver Code ======
    vector<int> res;
    MaxQueue* maxQueue = new MaxQueue();
    maxQueue->push_back(1);
    maxQueue->push_back(2);
    res.push_back(maxQueue->max_value());
    res.push_back(maxQueue->pop_front());
    res.push_back(maxQueue->max_value());
    PrintUtil::printVector(res);

    return 0;
}