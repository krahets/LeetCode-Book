/*
 * File: lc_8_string_to_integer_atoi_s1.cpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int myAtoi(string s) {
        int res = 0, bndry = INT_MAX / 10;
        int i = 0, sign = 1, length = s.size();
        if(length == 0) return 0;
        while(s[i] == ' ')
            if(++i == length) return 0;
        if(s[i] == '-') sign = -1;
        if(s[i] == '-' || s[i] == '+') i++;
        for(int j = i; j < length; j++) {
            if(s[j] < '0' || s[j] > '9') break;
            if(res > bndry || res == bndry && s[j] > '7')
                return sign == 1 ? INT_MAX : INT_MIN;
            res = res * 10 + (s[j] - '0');
        }
        return sign * res;
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
