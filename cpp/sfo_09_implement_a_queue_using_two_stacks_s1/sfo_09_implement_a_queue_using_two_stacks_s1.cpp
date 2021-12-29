/*
* File: sfo_09_implement_a_queue_using_two_stacks_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class CQueue {
public:
    stack<int> A, B;
    CQueue() {}
    void appendTail(int value) {
        A.push(value);
    }
    int deleteHead() {
        if(!B.empty()) {
            int tmp = B.top();
            B.pop();
            return tmp;
        }
        if(A.empty()) return -1;
        while(!A.empty()) {
            int tmp = A.top();
            A.pop();
            B.push(tmp);
        }
        int tmp = B.top();
        B.pop();
        return tmp;
    }
};

int main() {
    // ====== Driver Code ======
    vector<int> res;
    CQueue* cQueue = new CQueue();
    res.push_back(cQueue->deleteHead());
    cQueue->appendTail(5);
    cQueue->appendTail(2);
    res.push_back(cQueue->deleteHead());
    res.push_back(cQueue->deleteHead());
    PrintUtil::printVector(res);

    return 0;
}