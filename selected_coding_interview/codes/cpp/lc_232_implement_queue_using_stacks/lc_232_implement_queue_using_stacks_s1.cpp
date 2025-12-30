/*
 * File: lc_232_implement_queue_using_stacks_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class MyQueue {
private:
    std::stack<int> A, B;

public:
    MyQueue() {}

    void push(int x) {
        A.push(x);
    }

    int pop() {
        int peek = this->peek();
        B.pop();
        return peek;
    }

    int peek() {
        if (!B.empty()) return B.top();
        if (A.empty()) return -1;
        while (!A.empty()){
            B.push(A.top()), A.pop();
        }
        int res = B.top();
        return res;
    }

    bool empty() {
        return A.empty() && B.empty();
    }
};

int main() {
    // ======= Test Case =======
    // TODO: Add specific test case

    // ====== Driver Code ======
    Solution* slt = new Solution();
    // TODO: Call solution method and print result

    return 0;
}
