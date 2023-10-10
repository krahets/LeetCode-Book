/*
* File: sfo_67_convert_string_to_int_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    int strToInt(string str) {
        int res = 0, bndry = INT_MAX / 10;
        int i = 0, sign = 1, length = str.size();
        if(length == 0) return 0;
        while(str[i] == ' ')
            if(++i == length) return 0;
        if(str[i] == '-') sign = -1;
        if(str[i] == '-' || str[i] == '+') i++;
        for(int j = i; j < length; j++) {
            if(str[j] < '0' || str[j] > '9') break;
            if(res > bndry || res == bndry && str[j] > '7')
                return sign == 1 ? INT_MAX : INT_MIN;
            res = res * 10 + (str[j] - '0');
        }
        return sign * res;
    }
};

int main() {
    // ======= Test Case =======
    string str = "42";
    // ====== Driver Code ======
    Solution* slt = new Solution();
    int res = slt->strToInt(str);
    cout << res << endl;
    
    return 0;
}
