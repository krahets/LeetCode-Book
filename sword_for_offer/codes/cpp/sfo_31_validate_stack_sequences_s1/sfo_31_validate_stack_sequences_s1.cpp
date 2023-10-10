/*
* File: sfo_31_validate_stack_sequences_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> stk;
        int i = 0;
        for(int num : pushed) {
            stk.push(num); // num 入栈
            while(!stk.empty() && stk.top() == popped[i]) { // 循环判断与出栈
                stk.pop();
                i++;
            }
        }
        return stk.empty();
    }
};

int main() {
    // ======= Test Case =======
    vector<int> pushed = { 1, 2, 3, 4, 5 };
    vector<int> popped = { 4, 5, 3, 2, 1 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->validateStackSequences(pushed, popped);
    cout << boolalpha << res << endl;
    
    return 0;
}
