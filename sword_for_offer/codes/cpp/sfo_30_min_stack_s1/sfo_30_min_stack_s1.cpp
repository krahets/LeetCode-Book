/*
* File: sfo_30_min_stack_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class MinStack {
public:
    stack<int> A, B;
    MinStack() {}
    void push(int x) {
        A.push(x);
        if(B.empty() || B.top() >= x)
            B.push(x);
    }
    void pop() {
        if(A.top() == B.top())
            B.pop();
        A.pop();
    }
    int top() {
        return A.top();
    }
    int min() {
        return B.top();
    }
};

int main() {
    // ====== Driver Code ======
    vector<int> res;
    MinStack* minStack = new MinStack();
    minStack->push(-2);
    minStack->push(0);
    minStack->push(-3);
    res.push_back(minStack->min());
    minStack->pop();
    res.push_back(minStack->top());
    res.push_back(minStack->min());
    PrintUtil::printVector(res);

    return 0;
}